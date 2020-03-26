//import javax.swing.*;

import java.awt.*;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
import java.io.*;

import gui.MainFrame;
import gui.Settings;

public class Main implements Serializable {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {

            Settings settings = Settings.readSettings();
//            setWindowAnchor(getLocationOnScreen())


            try {
                FileOutputStream fos = new FileOutputStream("src\\main\\resources\\settings.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(settings);
                oos.close();
                fos.close();
/*                FileInputStream fis = new FileInputStream("src\\main\\resources\\settings.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);
                settings = (Settings) ois.readObject();
                */
            } catch (Exception e) {
                e.printStackTrace();
            }

            MainFrame mainWindow = new MainFrame(/*settings.tile, settings.location_x, settings.location_y, */settings);
            mainWindow.setVisible(true);
        });
    }
}