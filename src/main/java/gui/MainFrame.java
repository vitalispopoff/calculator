package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {

    public Settings settings;

    public MainFrame(Settings settings) throws HeadlessException {
        this.settings = settings;
        setWindowAnchor(settings.windowAnchor);
        setResizable(settings.windowResizable);
        setMainPanel(settings);
        setDefaultCloseOperation(Settings.windowDefaultCloseOperation);

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

    void setMainPanel(Settings settings) {
        MainPanel panel = new MainPanel(settings);
        add(panel);
    }

    public Point getWindowAnchorLocation() {
        return getLocationOnScreen();
    }
}