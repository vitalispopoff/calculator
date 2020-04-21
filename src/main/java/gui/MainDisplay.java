package gui;

import javax.swing.*;

public class MainDisplay extends JLabel {

    public MainDisplay(/*Settings settings, *//*String text,*/ /*int horizontalAlignment*/) {
        super(/*text*/"", /*horizontalAlignment*/SwingConstants.RIGHT);
        setBounds(
                0,
                0,
                (Settings.tile << 2) - (Settings.tile >> 2),
                Settings.tile);
    }
}