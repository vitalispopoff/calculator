package gui;

import static gui.Parsable.valueWriter;
import static _temp._CalculationNode.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import _temp._CalculationTree;

public class MainPanel extends JPanel {

    static int tile = 60;
    static JLabel display;
    static Character[][] buttons = {
            {'C', '^', '√', '*'},
            {'7', '8', '9', '/'},
            {'4', '5', '6', '+'},
            {'1', '2', '3', '-'},
            {'0', '.', '∓', '='}
    };
    Settings settings;
    private KeyListener numKey;

    public MainPanel(Settings value) {
        this.settings = value;

        tile = tile == 0 ? value.tile : tile;
        display = new MainDisplay (settings,"", SwingConstants.RIGHT);
        display.setBounds(0, 0, (tile << 2) - (tile >> 2), tile);

        setLayout(null);
        defineKeyListener();
        add(display);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                char c = buttons[i][j];
                JButton button = new JButton();
                button.setText("" + c);

                button.addActionListener(e -> {
                    if ((c > 47 && c < 58) || c == 46 || c == 8723) valueWriter(button.getText().charAt(0));
                    else if (c == 61) head.setValue();                  // equals (exec calculation)
                    else if (c == 94) _CalculationTree.addAsRoot();      // exponentiation;
                    else if (c == 8730) _CalculationTree.addAsRoot();    // roots;
                    else if (c == 42) _CalculationTree.addAsRoot();      // multiplication;
                    else if (c == 47) _CalculationTree.addAsRoot();      // division;
                    else if (c == 43) _CalculationTree.addAsRoot();      // addition;
                    else if (c == 45) _CalculationTree.addAsRoot();      // subtraction;
                    else if (c == 67) System.out.println(getLocationOnScreen());     // TODO clear
                });

                button.setBounds(j * tile, (i + 1) * tile, tile, tile);
                button.addKeyListener(numKey);
                add(button);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(4 * tile, 6 * tile);
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