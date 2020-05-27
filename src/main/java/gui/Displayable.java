package gui;

public interface Displayable {

//	@formatter:off

/*	static public final MainDisplay
			topDisplay = new MainDisplay(
				new Font("Sans-Serif", Font.PLAIN, 10),
				new Rectangle(Settings.tile >> 3, 0, (Settings.tile << 2) - (Settings.tile >> 2), Settings.tile / 3),
				SwingConstants.CENTER
			),
			bottomDisplay = new MainDisplay(
				new Font("Sans-Serif", Font.PLAIN, 14),
				new Rectangle(Settings.tile >> 3, Settings.tile / 3, (Settings.tile << 2) - (Settings.tile >> 2), (Settings.tile / 3) << 1),
				SwingConstants.CENTER
			);*/

	static public final Displayable
			topDisplay = Settings.topDisplay,
			bottomDisplay = Settings.bottomDisplay;

//	static void displayUpdate(){ topDisplay.setText(Node.content); }

//	@formatter:on

}