package gui;

import calculation.Words;

import javax.swing.*;

import static gui.Settings.buttons;

public class Button extends JButton {

    Button(int i, int j, int tile) {
        JButton button = new JButton();
        char c = buttons[i][j];
        button.setText("" + c);
        button.setBounds(j * tile, (i + 1) * tile, tile, tile);
        button.addActionListener(e -> pushTheButton(c));

    }

    private Words charToWord(char c) {
        return Words.ADD;
    }

    private void pushTheButton(char c) {
        Words word = charToWord(c);
        Words.valueOf(word.toString()).dupa();
    }
}
