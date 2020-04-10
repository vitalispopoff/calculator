package gui;

import _temp._CalculationTree;
import input.ValueParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import static _temp._CalculationNode.head;

public class MainPanel extends JPanel {

    static int tile = 60;
    static JLabel display;
    static char[] operationSigns = {42, 43, 45, 47, 61, 67, 94, 8730};
    static char[][] buttons = {
            {'C', '^', '√', '*'},
            {'7', '8', '9', '/'},
            {'4', '5', '6', '+'},
            {'1', '2', '3', '-'},
            {'0', '.', '∓', '='}
    };

    Settings settings;      // ? TODO isn't it disposable ?
    private KeyListener numKey;

    public MainPanel(Settings value) {
        this.settings = value;

        tile = tile == 0 ? value.tile : tile;
        display = new MainDisplay(settings, "", SwingConstants.RIGHT);

        setLayout(null);
        defineKeyListener();
        add(display);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                char c = buttons[i][j];
                JButton button = new JButton();
                button.setText("" + c);

                button.addActionListener(e -> {
                    if ((c > 47 && c < 58) || c == 46 || c == 8723) new ValueParser(button.getText().charAt(0));
                    else {
                        switch (isOperationSign()) {
                            case 0:
                                _CalculationTree.addAsRoot();               // multiplication;
                                break;
                            case 1:
                                _CalculationTree.addAsRoot();               // addition;
                                break;
                            case 2:
                                _CalculationTree.addAsRoot();                 // subtraction;
                                break;
                            case 3:
                                _CalculationTree.addAsRoot();                 // division;
                                break;
                            case 4:
                                head.setValue();                              // equals (exec calculation)
                                break;
                            case 5:
                                System.out.println(getLocationOnScreen());    // TODO clear
                                break;
                            case 6:
                                _CalculationTree.addAsRoot();                 // exponentiation;
                                break;
                            case 7:
                                _CalculationTree.addAsRoot();                 // roots;
                                break;
                        }
                    }

                      /*  if (isOperationSign() != -1) {
                        new ValueParser('&');

                        switch (isOperationSign())
                    else if (c == 61) head.setValue();                              // equals (exec calculation)
                        else if (c == 94) _CalculationTree.addAsRoot();                 // exponentiation;
                        else if (c == 8730) _CalculationTree.addAsRoot();               // roots;
                        else if (c == 42) _CalculationTree.addAsRoot();                 // multiplication;
                        else if (c == 47) _CalculationTree.addAsRoot();                 // division;
                        else if (c == 43) _CalculationTree.addAsRoot();                 // addition;
                        else if (c == 45) _CalculationTree.addAsRoot();                 // subtraction;
                        else if (c == 67) System.out.println(getLocationOnScreen());    // TODO clear
                    }*/ // TODO disposable
                });

                button.setBounds(j * tile, (i + 1) * tile, tile, tile);
                button.addKeyListener(numKey);
                add(button);
            }
        }
    }

    static int isOperationSign() {
        return Arrays.toString(operationSigns).indexOf('&');
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