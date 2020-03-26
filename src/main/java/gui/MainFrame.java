package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;

public class MainFrame extends JFrame implements Serializable {

//    public static Settings settings = new Settings();

    public MainFrame(/*int tile, int location_x, int location_y, */Settings settings) throws HeadlessException {


        setWindowAnchor(/*new Point(location_x, location_y*/ settings.windowAnchor);
        setResizable(false);
        setMainPanel(settings.tile);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent anEvent) {
//                Settings settingsCache = settings;

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
