package _temp.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static _temp.calculation.Nodeable.*;

public class MainPanel extends JPanel implements KeyListener {

    static int tile = 60;
    static JLabel display;
    static final char[][] buttons = {
            {'C', '^', '√', '*'},
            {'7', '8', '9', '/'},
            {'4', '5', '6', '+'},
            {'1', '2', '3', '-'},
            {'0', '.', '∓', '='}
    };
    private KeyListener numKey;

    public MainPanel(Settings settings) {

        tile = tile == 0 ? settings.tile : tile;
        display = new MainDisplay(settings, "", SwingConstants.RIGHT);

        setLayout(null);
//        defineKeyListener();
        add(display);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                char c = buttons[i][j];
                JButton button = new JButton();
                button.setText("" + c);
                button.setBounds(j * tile, (i + 1) * tile, tile, tile);
                button.addKeyListener(numKey);
                button.addActionListener(e -> dupa(c) );    // ! to be reorganized
                add(button);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(4 * tile, 6 * tile);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}