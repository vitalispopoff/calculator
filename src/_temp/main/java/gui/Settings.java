package gui;

import static calculation.NodeType.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.io.Serializable;


public class Settings implements Serializable {

    private static final String
            fileAddress = "src\\main\\resources\\settings.txt";
    public static Button[] basicCalculator = {
            new Button( CLEAR, 'C'),        //   0
            new Button( EXPONENT, '^'),     //   1
            new Button( ROOT, '√'),         //   2
            new Button( MULTIPLY, '*'),     //   3
            new Button( VALUE, '7'),        //   4
            new Button( VALUE, '8'),        //   5
            new Button( VALUE, '9'),        //   6
            new Button( DIVIDE, '/'),       //   7
            new Button( VALUE, '4'),        //   8
            new Button( VALUE, '5'),        //   9
            new Button( VALUE, '6'),        //  10
            new Button( ADD, '+'),          //  11
            new Button( VALUE, '1'),        //  12
            new Button( VALUE, '2'),        //  13
            new Button( VALUE,'3'),         //  14
            new Button( SUBTRACT, '-'),     //  15
            new Button( SPIN, '∓'),         //  16
            new Button( VALUE, '0'),        //  17
            new Button( VALUE, '.'),        //  18
            new Button( EVALUATE, '='),     //  19
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