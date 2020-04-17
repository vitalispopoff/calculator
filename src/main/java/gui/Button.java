package gui;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import calculation.Words;

public class Button extends JButton implements KeyListener {

    static int
            tile = 60,
            rowLength = 5;
    private Words word;
    private char symbol;

    Button(char symbol, Words word) {
        this.symbol = symbol;
        this.word = word;
        setText(Character.toString(symbol));
        addInteraction(word);
    }

    void setButtonBounds(int i, int tile) {
        int
                hor = (i % 4) * tile,
                ver = (1 + (i >> 2)) * tile;
        setBounds(hor, ver, tile, tile);
    }

    private void addInteraction(Words word) {
        addActionListener(e -> Words.valueOf(word.toString()).interact());
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