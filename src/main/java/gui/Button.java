package gui;

import static gui.Settings.buttonRowLength;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import calculation.*;

public class Button extends JButton implements KeyListener {

    static boolean valueSequence = true;
    private Typical type;
    private char symbol;

    Button(char symbol, NodeType type) {
        setSymbol(symbol);
        setType(type);
        setText(Character.toString(symbol));
        addInteraction(type);
    }

    void setButtonBounds(int i, int tile) {
        int
                hor = (i % buttonRowLength) * tile,
                ver = (1 + (i / buttonRowLength)) * tile;
        setBounds(hor, ver, tile, tile);
    }

    private void addInteraction(Typical type) {
        addActionListener(e -> type.interact());
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

    //    @formatter:off
    void setSymbol(char symbol){this.symbol= symbol;}
    void setType(Typical type){this.type = type;}
    //    @formatter:on
}