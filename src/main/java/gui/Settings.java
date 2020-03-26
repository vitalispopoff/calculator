package gui;

import java.awt.*;
import java.io.*;
import java.io.Serializable;

public class Settings implements Serializable {

    private static String fileAddress = "src\\main\\resources\\settings.txt";
    public int
            tile = 60,
            location_x = 200,
            location_y = 200;
    public Point
            windowAnchor = new Point(location_x, location_y);

    public Settings() {}

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

    public /*static*/ void writeSettings(Point windowNewAnchor) {
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