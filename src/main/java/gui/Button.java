package gui;

import static gui.Settings.buttonRowLength;

import javax.swing.*;
import java.awt.event.*;

import calculation.*;

public class Button extends JButton implements KeyListener {

    static boolean valueSequence = true;
    private Typical type;
    private char symbol;

    Button(char symbol, NodeType type) {
        setName("button_" + symbol);
        setSymbol(symbol);
        setType(type);
        setText(Character.toString(symbol));
        addInteraction();
    }

    void setButtonBounds(int i, int tile) {
        setBounds(
                (i % buttonRowLength) * tile,
                (1 + (i / buttonRowLength)) * tile,
                tile,
                tile
        );
    }

    private void addInteraction() {
        addActionListener(e -> Typical.interact(type, symbol));
    }

    //    @formatter:off

    @Override public void keyTyped(KeyEvent e) {
    }
    @Override public void keyPressed(KeyEvent e) {
    }
    @Override public void keyReleased(KeyEvent e) {
    }

    void setSymbol(char symbol){this.symbol= symbol;}
    void setType(Typical type){this.type = type;}

    //    @formatter:on
}