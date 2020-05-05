package gui;

import static gui.Settings.buttonRowLength;

import javax.swing.*;
import java.awt.event.*;

import calculation.*;

public class Button extends JButton implements KeyListener {

    static boolean valueSequence = true;
    private Typical type;
    private char symbol;

    public Button(NodeType type, char symbol) {
        setName("button_" + symbol);
        setText(symbol);
        setType(type);
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
        addActionListener(e -> type.interact(this));
    }

    void setText(char symbol){
    setText(Character.toString(symbol));
    }

    char getSymbol(){
        String
                cache = getText();
        return cache.charAt(cache.length()-1);
    }

    //    @formatter:off

    @Override public void keyTyped(KeyEvent e) { }
    @Override public void keyPressed(KeyEvent e) { }
    @Override public void keyReleased(KeyEvent e) { }

    void setType(Typical type){this.type = type;}
    public Typical getType(){return type;}

    //    @formatter:on
}