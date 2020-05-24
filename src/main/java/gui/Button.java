package gui;

import gui.Interactive.Whatevah;
import logic.Type;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static gui.Settings.buttonRowLength;

public class Button extends JButton /*implements KeyListener*/ {

	Whatevah whatevah;
	ActionEvent event;

	public Button(Interactive action, Type type, char symbol) {
		setNameAndText(symbol);
		setWhatevah(type,symbol);

		addActionListener(e ->action.interact(whatevah));
		System.out.println("button "+symbol);
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
		whatevah = new Whatevah(type, symbol);
	}

	void setNameAndText(char symbol) {
		setName("button_" + symbol);
		setText(Character.toString(symbol));
	}

//	void setAction(Interactive action){this.action = action;}


//	KeyListener implementation  //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

//	@Override public void keyTyped(KeyEvent e) { }
//	@Override public void keyPressed(KeyEvent e) { }
//	@Override public void keyReleased(KeyEvent e) { }

//	@formatter:on

}