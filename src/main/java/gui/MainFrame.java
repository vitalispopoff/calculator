package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {


    public MainFrame(int tile) throws HeadlessException {
        setLocation(200, 200);
        setResizable(false);

        MainPanel panel = new MainPanel(tile);

        add(panel);
        pack();

    }


}
