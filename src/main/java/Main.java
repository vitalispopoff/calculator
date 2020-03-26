import java.awt.*;
import java.io.*;
import gui.*;

public class Main implements Serializable {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {

            Settings settings = Settings.readSettings();

            try {
                FileOutputStream fos = new FileOutputStream("src\\main\\resources\\settings.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(settings);
                oos.close();
                fos.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            MainFrame mainWindow = new MainFrame(settings);
            mainWindow.setVisible(true);
        });
    }
}