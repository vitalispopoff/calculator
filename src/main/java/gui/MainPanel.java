package gui;

import data.Node;

import javax.swing.*;
import java.awt.*;

import static gui.Settings.basicCalculator;

public class MainPanel extends JPanel {

//	@formatter:off

	static String
			topDisplayContent =  Node.content,
			bottomDisplayContent;

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
//		tile = tile == 0 ? settings.tile : tile;

		int
				i = 0/*,
				width = (Settings.tile << 2) - (Settings.tile >> 2)*/;

		setLayout(null);

		add(topDisplay
				/*new MainDisplay(
						new Font("Sans-Serif", Font.PLAIN, 10),
						new Rectangle(
								0,
								0,
								width,
								Settings.tile / 3),
						SwingConstants.CENTER
				)*/
		);

		add(bottomDisplay
				/*new MainDisplay(
						new Font("Sans-Serif", Font.PLAIN, 14),
						new Rectangle(
								0,
								Settings.tile / 3,
								width,
								(Settings.tile / 3) << 1),
						SwingConstants.CENTER
				)*/
		);


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