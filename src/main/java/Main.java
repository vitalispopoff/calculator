import gui.*;

import java.awt.*;

public class Main {

	public static void main(String[] args) {

		EventQueue.invokeLater(()->{

			Settings
				settings = Settings.readSettings();

			MainFrame
				mainWindow = new MainFrame(settings);

			mainWindow.setVisible(true);
		});
	}
}