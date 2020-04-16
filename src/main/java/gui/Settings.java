package gui;

import calculation.Words;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.io.Serializable;

public class Settings implements Serializable {

    private static final String
            fileAddress = "src\\main\\resources\\settings.txt";
/*    static final char[][] buttons = {
            {'C', '^', '√', '*'},
            {'7', '8', '9', '/'},
            {'4', '5', '6', '+'},
            {'1', '2', '3', '-'},
            {'0', '.', '∓', '='}
    };*/

    static /*final*/ Button[] basicCalculator ={
            new Button('C', Words.CLEAR),
            new Button('^', Words.EXPONENT),
            new Button('√', Words.ROOT),
            new Button('*', Words.MULTIPLY),
            new Button('7', Words.VALUE),
            new Button('8', Words.VALUE),
            new Button('9', Words.VALUE),
            new Button('/', Words.DIVIDE),
            new Button('4', Words.VALUE),
            new Button('5', Words.VALUE),
            new Button('6', Words.VALUE),
            new Button('+', Words.ADD),
            new Button('1', Words.VALUE),
            new Button('2', Words.VALUE),
            new Button('3', Words.VALUE),
            new Button('-', Words.SUBTRACT),
            new Button('∓', Words.SIGN),
            new Button('0', Words.VALUE),
            new Button('.', Words.VALUE),
            new Button('=', Words.EVALUATE),
    };

/*public static final char[]
            operationSigns = {42, 43, 45, 47, 61, 67, 94, 8730},
            numberSigns = {46, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 8723};*/     // disposable
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