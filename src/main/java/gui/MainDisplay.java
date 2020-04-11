package gui;

import javax.swing.*;

public class MainDisplay extends JLabel {

    public MainDisplay(Settings settings, String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        setBounds(0, 0, (settings.tile << 2) - (settings.tile >> 2), settings.tile);
    }
}