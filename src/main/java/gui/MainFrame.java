package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {

    public MainFrame(Settings settings) throws HeadlessException {
        setWindowAnchor(settings.windowAnchor);
        setResizable(settings.windowResizable);
        setMainPanel(settings.tile);
        setDefaultCloseOperation(settings.windowDefaultCloseOperation);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent anEvent) {
                settings.writeSettings(getWindowAnchorLocation());
                System.exit(0);
            }
        });
        pack();
    }

    void setWindowAnchor(Point windowAnchor) {
        setLocation(windowAnchor);
    }

    void setMainPanel(int tile) {
        MainPanel panel = new MainPanel(tile);
        add(panel);
    }

    public Point getWindowAnchorLocation() {
        return getLocationOnScreen();
    }
}