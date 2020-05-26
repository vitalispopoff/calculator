package gui;

import javax.swing.*;
import java.awt.*;

import static gui.Settings.basicCalculator;

public class MainPanel extends JPanel /*implements Observer*/ {

//	@formatter:off

/*	static String
			topDisplayContent =  Node.content,
			bottomDisplayContent;*/		// ? disposable ?

	private int
			tile = 60;
	static public MainDisplay
			topDisplay = new MainDisplay(
				new Font("Sans-Serif", Font.PLAIN, 10),
				new Rectangle(Settings.tile >> 3, 0, (Settings.tile << 2) - (Settings.tile >> 2), Settings.tile / 3),
				SwingConstants.CENTER),
			bottomDisplay = new MainDisplay(
				new Font("Sans-Serif", Font.PLAIN, 14),
				new Rectangle(Settings.tile >> 3, Settings.tile / 3, (Settings.tile << 2) - (Settings.tile >> 2), (Settings.tile / 3) << 1),
				SwingConstants.CENTER);

//	@formatter:on

	public MainPanel(Settings settings) {
		int i = 0;

		setLayout(null);
		add(topDisplay);
		add(bottomDisplay);

		for (Button b : basicCalculator) {
			b.setButtonBounds(i++, tile);
			add(b);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(4 * tile, 6 * tile);
	}

/*	@Override
	public void update(Observable o, Object arg) {
	}*/		// ? disposable ?
}