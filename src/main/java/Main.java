import java.awt.*;
import java.io.*;

import gui.*;

public class Main implements Serializable {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            Settings settings = Settings.readSettings();
            MainFrame mainWindow = new MainFrame(settings);
            mainWindow.setVisible(true);
        });
    }
}