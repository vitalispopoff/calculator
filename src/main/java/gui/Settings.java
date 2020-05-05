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
            new Button( CLEAR, 'C'),
            new Button( EXPONENT, '^'),
            new Button( ROOT, '√'),
            new Button( MULTIPLY, '*'),
            new Button( VALUE, '7'),
            new Button( VALUE, '8'),
            new Button( VALUE, '9'),
            new Button( DIVIDE, '/'),
            new Button( VALUE, '4'),
            new Button( VALUE, '5'),
            new Button( VALUE, '6'),
            new Button( ADD, '+'),
            new Button( VALUE, '1'),
            new Button( VALUE, '2'),
            new Button( VALUE,'3'),
            new Button( SUBTRACT, '-'),
            new Button( SPIN, '∓'),
            new Button( VALUE, '0'),
            new Button( VALUE, '.'),
            new Button( EVALUATE, '='),
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