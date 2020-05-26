package gui;

import javax.swing.*;
import java.awt.*;

import static gui.Settings.basicCalculator;

public class MainPanel extends JPanel {

	private int tile = 60;
//	public static MainDisplay secondaryDisplay = /*new MainDisplay(0)*/ Settings.displays[0];
//	public static MainDisplay mainDisplay = /*new MainDisplay(1)*/Settings.displays[1];

	public MainPanel(Settings settings) {
		int i = 0;

		tile = tile == 0 ? settings.tile : tile;

		setLayout(null);
//		add(secondaryDisplay);
//		add(mainDisplay);


		add(new MainDisplay(
				new Font("Sans-Serif", Font.PLAIN, 10),
				new Rectangle(
						0,
						Settings.tile >> 2,
						(Settings.tile << 2) - (Settings.tile >> 2),
						Settings.tile >> 2)
		));
		add(new MainDisplay(
				new Font("Sans-Serif", Font.PLAIN, 14),
				new Rectangle(
						0,
						Settings.tile >> 2,
						(Settings.tile << 2) - (Settings.tile >> 2),
						(Settings.tile >> 2) + (Settings.tile >> 1)
				)
		));


		for (Button b : basicCalculator) {
			b.setButtonBounds(i++, tile);
			add(b);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(4 * tile, 6 * tile);
	}
}