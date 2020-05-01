package gui;

import static calculation.NodeType.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.io.Serializable;


public class Settings implements Serializable {

    private static final String
            fileAddress = "src\\main\\resources\\settings.txt";
    static Button[] basicCalculator = {
            new Button('C', CLEAR),
            new Button('^', EXPONENT),
            new Button('√', ROOT),
            new Button('*', MULTIPLY),
            new Button('7', VALUE),
            new Button('8', VALUE),
            new Button('9', VALUE),
            new Button('/', DIVIDE),
            new Button('4', VALUE),
            new Button('5', VALUE),
            new Button('6', VALUE),
            new Button('+', ADD),
            new Button('1', VALUE),
            new Button('2', VALUE),
            new Button('3', VALUE),
            new Button('-', SUBTRACT),
            new Button('∓', SPIN),
            new Button('0', VALUE),
            new Button('.', VALUE),
            new Button('=', EVALUATE),
    };
    public Point
            windowAnchor = new Point(200, 200);
    static public int
            tile = 60,
            buttonRowLength = 4,
            windowDefaultCloseOperation = JFrame.DO_NOTHING_ON_CLOSE;
    public boolean
            windowResizable = false;

    public Settings() {
    }

    public static Settings readSettings() {
        Settings cache = new Settings();
        try {
            FileInputStream
                    fis = new FileInputStream(fileAddress);
            ObjectInputStream
                    ois = new ObjectInputStream(fis);
            cache = (Settings) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cache;
    }

    public void writeSettings(Point windowNewAnchor) {
        setWindowAnchor(windowNewAnchor);
        try {
            FileOutputStream
                    fos = new FileOutputStream(fileAddress);
            ObjectOutputStream
                    oos = new ObjectOutputStream(fos);
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