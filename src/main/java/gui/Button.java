package gui;

import logic.Type;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static gui.Settings.*;

public class Button extends JButton implements KeyListener {

//	@formatter:off

	static boolean valueSequence = true;
	private Type type = null;
//	private Interactive action = null;
	private char symbol;


	public Button(Type type, char symbol) {
		setNameAndText(symbol);
//		setAction(Interaction.SOLVE);
		setType(type);
		addInteraction(Interaction.SOLVE);
	}
	public Button(Interactive action, char symbol) {
		setNameAndText(symbol);
//		setAction(action);
		addInteraction(action);
	}

	public Button(Interactive action, Type type, char symbol) {
		setNameAndText(symbol);
//		setAction(action);
		setType(type);
		addInteraction(action);
	}

	private void addInteraction(Interactive action) { addActionListener(e -> action.interact());}

	void setButtonBounds(int i, int tile) {
		setBounds(
				(i % buttonRowLength) * tile,
				(1 + (i / buttonRowLength)) * tile,
				tile,
				tile
		);
	}

/*	void setAction(Interactive action) {
		this.action = action;
	}*/

	/*void setName(char symbol) { }*/		// ? disposable ?
	void setNameAndText(char symbol) {
		setName("button_" + symbol);
		setText(Character.toString(symbol));
	}
	void setType(Type type) { this.type = type; }

//	KeyListener implementation  //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override public void keyTyped(KeyEvent e) { }
	@Override public void keyPressed(KeyEvent e) { }
	@Override public void keyReleased(KeyEvent e) { }

//	@formatter:on

}