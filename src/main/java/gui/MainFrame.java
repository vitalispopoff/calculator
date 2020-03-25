package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(int tile, int location_x, int location_y) throws HeadlessException {
        setLocation(location_x, location_y);
        setResizable(false);

        MainPanel panel = new MainPanel(tile);

        add(panel);
        pack();
    }
}