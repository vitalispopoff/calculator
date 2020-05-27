package gui;

import interaction.Interactive;
import interaction.Interactive.ButtonDetails;
import logic.Type;

import javax.swing.*;
import java.awt.event.*;

import static gui.Settings.buttonRowLength;

public class Button extends JButton implements KeyListener {

	ButtonDetails buttonDetails;
	ActionEvent event;

	public Button(Interactive action, Type type, char symbol) {
		setNameAndText(symbol);
		setWhatevah(type,symbol);
		addActionListener(e -> {
			action.interactWithData(buttonDetails);
			Interactive.interactWithOutput(action);
		});
	}

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	void setButtonBounds(int i, int tile) {
		setBounds(
				(i % buttonRowLength) * tile,
				(1 + (i / buttonRowLength)) * tile,
				tile,
				tile
		);
	}

	//	@formatter:off

	void setWhatevah(Type type, char symbol){
		buttonDetails = new ButtonDetails(type, symbol);
	}

	void setNameAndText(char symbol) {
		setName("button_" + symbol);
		setText(Character.toString(symbol));
	}

//	KeyListener implementation  //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override public void keyTyped(KeyEvent e) { }
	@Override public void keyPressed(KeyEvent e) { }
	@Override public void keyReleased(KeyEvent e) { }

//	@formatter:on

}