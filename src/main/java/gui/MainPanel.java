package gui;

import calculation.Node;
import calculation.calculations.*;
import input.Queuer;
import input.ValueParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import static calculation.Node.mainRoot;
import static calculation.Nodeable.*;

public class MainPanel extends JPanel implements KeyListener {

    static int tile = 60;
    static JLabel display;
/*    static final char[]
            operationSigns = {42, 43, 45, 47, 61, 67, 94, 8730},
            numberSigns = {46, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 8723};*/
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

/*    static int isValidSign(char[] signArray, char c) {
        return Arrays.toString(signArray).indexOf(c);
    }*/ // ! moved to Nodeable

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(4 * tile, 6 * tile);
    }

/*    @Override
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
    }*/

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