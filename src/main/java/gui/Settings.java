package gui;

import calculation.NodeType;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.io.Serializable;

public class Settings implements Serializable {

    private static final String
            fileAddress = "src\\main\\resources\\settings.txt";
    static Button[] basicCalculator = {
            new Button('C', NodeType.CLEAR),
            new Button('^', NodeType.EXPONENT),
            new Button('√', NodeType.ROOT),
            new Button('*', NodeType.MULTIPLY),
            new Button('7', NodeType.VALUE),
            new Button('8', NodeType.VALUE),
            new Button('9', NodeType.VALUE),
            new Button('/', NodeType.DIVIDE),
            new Button('4', NodeType.VALUE),
            new Button('5', NodeType.VALUE),
            new Button('6', NodeType.VALUE),
            new Button('+', NodeType.ADD),
            new Button('1', NodeType.VALUE),
            new Button('2', NodeType.VALUE),
            new Button('3', NodeType.VALUE),
            new Button('-', NodeType.SUBTRACT),
            new Button('∓', NodeType.SIGN),
            new Button('0', NodeType.VALUE),
            new Button('.', NodeType.VALUE),
            new Button('=', NodeType.EVALUATE),
    };
    public Point
            windowAnchor = new Point(200, 200);
    public int
            tile = 60,
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