package gui;

import javax.swing.*;
import java.awt.*;

import static gui.Settings.basicCalculator;

public class MainPanel extends JPanel {

    private int tile = 60;
    static JLabel display;

    public MainPanel(Settings settings) {
        int i = 0;
        tile
                = tile == 0
                ? settings.tile
                : tile;
        display = new MainDisplay();

        setLayout(null);
        add(display);

        for (Button b : basicCalculator) {
            b.setButtonBounds(i++, tile);
            add(b);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(4 * tile, 6 * tile);
    }
}