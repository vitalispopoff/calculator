//	@formatter:off

package gui;

import data.Node;
import logic.Parsable;

import javax.swing.*;
import java.awt.*;

import static gui.Settings.basicCalculator;

public class MainPanel extends JPanel {

	private int
		tile = 60;
	static public MainDisplay
		topDisplay = new MainDisplay(
						new Font("Sans-Serif", Font.PLAIN, 10),
						new Rectangle(	Settings.tile >> 3,
										0,
										(Settings.tile << 2) - (Settings.tile >> 2),
										Settings.tile / 3),
						SwingConstants.CENTER),
		bottomDisplay = new MainDisplay(
							new Font("Sans-Serif", Font.PLAIN, 14),
							new Rectangle(	Settings.tile >> 3,
											Settings.tile / 3,
											(Settings.tile << 2) - (Settings.tile >> 2),
											(Settings.tile / 3) << 1),
							SwingConstants.CENTER);

//	--------------------------------------------------------------------------------------------------------------------

	public MainPanel(Settings settings) {

		int
			i = 0;

		setLayout(null);
		add(topDisplay);
		add(bottomDisplay);

		for (Button b : basicCalculator) {

			b.setButtonBounds(i++, tile);
			add(b);
		}
	}

//	--------------------------------------------------------------------------------------------------------------------

	public static void topDisplayUpdate(){

		topDisplay.setText(Node.content+Parsable.ParsableCache.getParserCache());
	}

	public static void bottomDisplayUpdate(String string){

		bottomDisplay.setText(string);
	}

	@Override
	public Dimension getPreferredSize() {

		return new Dimension(4 * tile, 6 * tile);
	}
}

//	@formatter:on