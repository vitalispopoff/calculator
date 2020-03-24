package gui;

import calculation.CalculationNode;

import static calculation.CalculationNode.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static gui.Parsable.valueWriter;

public class MainPanel extends JPanel {

    static int tile = 0;
    static JLabel display;
    private KeyListener numKey;

    public MainPanel(int value) {
        tile = tile == 0 ? value : tile;
        display = new JLabel("", SwingConstants.RIGHT);

        setLayout(null);

        display = new JLabel("", SwingConstants.RIGHT);
        defineKeyListener();
        display.setBounds(0, 0, (tile << 2) - (tile >> 2), tile);
        add(display);

        String[][] buttons = {
                {"", "", "", "", "*"},
                {"7", "8", "9", "/"},
                {"4", "5", "6", "+"},
                {"1", "2", "3", "-"},
                {"0", ".", "+/-", "="}
        };

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                JButton button = new JButton();
                button.setText(buttons[i][j]);
                if (i > 0 && j < 3)
                    button.addActionListener(e -> {
                        valueWriter(button.getText().charAt(0));    // TODO link to a number string assembler
                    });
                else if(i == 4 && j == 4)
                    button.addActionListener(e ->{
                        head.setValue();
                    });
                else{
                    button.addActionListener(e ->{
//                        new CalculationNode().operate(); TODO link to a calculation operations
                    });
                }


                button.setBounds(j * tile, (i + 1) * tile, tile, tile);
                button.addKeyListener(numKey);
                add(button);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(4 * tile, 5 * tile);
    }

    private void defineKeyListener() {
        numKey = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent f) {
                f.getKeyChar();
            }

            @Override
            public void keyReleased(KeyEvent g) {
            }
        };
    }
}