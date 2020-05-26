package gui;

import javax.swing.*;
import java.awt.*;

public class MainDisplay extends JLabel{

/*	public MainDisplay(int ySlot){
		super();
		setText("0.");
		setHorizontalAlignment(SwingConstants.RIGHT);
		setVerticalAlignment(SwingConstants.CENTER);
		setFont(new Font("Sans-Serif", Font.PLAIN, 10+2*ySlot));

		setBounds(new Rectangle(
				0,
				ySlot*(Settings.tile>>2),
				(Settings.tile<<2) - (Settings.tile>>2),
				(ySlot*Settings.tile>>1)+(Settings.tile>>2)));
	}*/

	public MainDisplay(Font font, Rectangle bounds){
		setText("0.");
		setHorizontalAlignment(SwingConstants.RIGHT);
		setVerticalAlignment(SwingConstants.CENTER);
		setFont(font);
		setBounds(bounds);
	}
}