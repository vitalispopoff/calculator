package gui;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.io.Serializable;

public class Settings implements Serializable {

    private static String fileAddress = "src\\main\\resources\\settings.txt";
    public boolean windowResizable = false;
    public int
            tile = 60,
            windowDefaultCloseOperation = JFrame.DO_NOTHING_ON_CLOSE;
    public Point
            windowAnchor = new Point(200, 200);                                                           // TODO needs rewriting

    public Settings() {
    }

    public static Settings readSettings() {
        Settings cache = new Settings();
        try {
            FileInputStream fis = new FileInputStream(fileAddress);
            ObjectInputStream ois = new ObjectInputStream(fis);
            cache = (Settings) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cache;
    }

    public void writeSettings(Point windowNewAnchor) {
        setWindowAnchor(windowNewAnchor);
        try {
            FileOutputStream fos = new FileOutputStream(fileAddress);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            fos.close();

        } catch (Exception f) {
            f.printStackTrace();
        }
    }

    void setWindowAnchor(Point windowNewAnchor) {
        this.windowAnchor = windowNewAnchor;
    }
}

/*
 *   FIXME FileNotFoundException
 * */