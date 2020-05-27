package gui;

import interaction.Interactive;
import interaction.Interactive.Whatevah;
import logic.Type;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static gui.Settings.buttonRowLength;

public class Button extends JButton implements KeyListener {

	Whatevah whatevah;
	ActionEvent event;

	public Button(Interactive action, Type type, char symbol) {
		setNameAndText(symbol);
		setWhatevah(type,symbol);
		addActionListener(e -> {
			action.interact(whatevah);
			MainPanel.displayUpdate();
			Interactive.dupa(action);
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
		whatevah = new Whatevah(type, symbol);
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