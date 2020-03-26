package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;

public class MainFrame extends JFrame implements Serializable {

    public MainFrame(Settings settings) throws HeadlessException {
        setWindowAnchor(settings.windowAnchor);
        setResizable(false);
        setMainPanel(settings.tile);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

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