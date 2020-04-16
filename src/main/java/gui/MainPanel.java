package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainPanel extends JPanel implements KeyListener {

    static int tile = 60;
    static JLabel display;


    public MainPanel(Settings settings) {

        tile = tile == 0 ? settings.tile : tile;
        display = new MainDisplay(settings, "", SwingConstants.RIGHT);

        setLayout(null);
        add(display);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++)
                add(new Button(i, j, tile));
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