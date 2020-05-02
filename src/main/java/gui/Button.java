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
        setSymbol(symbol);
        setType(type);
        setText(Character.toString(symbol));
        addInteraction(/*symbol, type*/);
    }

    void setButtonBounds(int i, int tile) {
        int
                locX = (i % buttonRowLength) * tile,
                locY = (1 + (i / buttonRowLength)) * tile;
        setBounds(locX, locY, tile, tile);
    }

    private void addInteraction() {
        addActionListener(e -> Typical.interact(type, symbol));
    }

    /*private void addInteraction(Typical type) {
        addActionListener(e -> type.interact());
    }*/ // ? disposable ?

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    //    @formatter:off
    void setSymbol(char symbol){this.symbol= symbol;}
    void setType(Typical type){this.type = type;}
    //    @formatter:on
}