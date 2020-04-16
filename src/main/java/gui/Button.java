package gui;

//import static gui.Settings.basicCalculator;
//import static gui.Settings.buttons;

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

/*    Button(int tile, Point vector) {
        int
                i = vector.x,
                j = vector.y;
//        char c = buttons[i][j];
        setText("" + c);
        setBounds(j * tile, (i + 1) * tile, tile, tile);
        addActionListener(e -> pushTheButton(c));
    }*/

    Button(char symbol, Words word) {
        this.symbol = symbol;
        this.word = word;
        setText(Character.toString(symbol));
        addInteraction(word);
    }

    void setButtonBounds(int i, int tile) {
        int
                h_1 = (i % 4),
                v_1 = (1 + (i >> 2)),
                hor = h_1 * tile,
                ver = v_1 * tile;
        setBounds(hor, ver, tile, tile);
        System.out.println(i +", hor: "+ h_1+ ", ver: "+v_1+", ");
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