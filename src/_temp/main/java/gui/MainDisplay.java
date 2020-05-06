package gui;

import javax.swing.*;

public class MainDisplay extends JLabel {

    public MainDisplay() {
        super("", SwingConstants.RIGHT);
        setBounds(
                0,
                0,
                (Settings.tile << 2) - (Settings.tile >> 2),
                Settings.tile);
    }
}