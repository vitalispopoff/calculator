package gui;

import javax.swing.*;
import java.awt.*;

import static gui.Settings.basicCalculator;

public class MainPanel extends JPanel {

    private int tile = 60;
    static JLabel display;

    public MainPanel(Settings settings) {

        tile = tile == 0 ? settings.tile : tile;
        display = new MainDisplay(settings, "", SwingConstants.RIGHT);

        setLayout(null);
        add(display);
/*        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++)             // ! FIXME
                add(new Button(i, j, tile));

        }*/

        for (int i = 0; i < basicCalculator.length; i++) {
            Button button = basicCalculator[i];
            button.setButtonBounds(i, tile);
            add(button);


        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(4 * tile, 6 * tile);
    }
}