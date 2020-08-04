package gui;

import javax.swing.*;
import java.awt.*;

public class MainDisplay extends JLabel {

	public MainDisplay(Font font, Rectangle bounds, int constant){

		setFont(font);
		setText("0.");

		setVerticalAlignment(constant);
		setHorizontalAlignment(SwingConstants.RIGHT);

		setBounds(bounds);
	}
}