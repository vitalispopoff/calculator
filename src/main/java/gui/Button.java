package gui;

import logic.Type;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static gui.Settings.*;

public class Button extends JButton implements KeyListener {



	static boolean
			valueSequence = true;
	private Type
			type = null;
	Interactive
			action;
	private char
			symbol;

	public Button(Type type, char symbol) {
		setNameAndText(symbol);
		setType(type);
		setAction(Interaction.ADD_TO_QUEUE);
		addInteraction(/*this*/);
	}
	public Button(Interactive action, char symbol) {
		setNameAndText(symbol);
		setAction(action);
		addInteraction(/*this*/);
	}
	public Button(Interactive action, Type type, char symbol) {
		setNameAndText(symbol);
		setType(type);
		setAction(action);
		addInteraction(/*this*/);
	}

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	private void addInteraction() {
		addActionListener(e -> System.out.println(symbol));
				/*this.action.interact(this))*/;}

	void setButtonBounds(int i, int tile) {
		setBounds(
				(i % buttonRowLength) * tile,
				(1 + (i / buttonRowLength)) * tile,
				tile,
				tile
		);
	}

	//	@formatter:off

	void setNameAndText(char symbol) {
		setName("button_" + symbol);
		setText(Character.toString(symbol));
	}
	void setType(Type type) { this.type = type; }
	void setAction(Interactive action){this.action = action;}

	char getSymbol() { return symbol; }
	Type getType() { return type; }

//	KeyListener implementation  //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override public void keyTyped(KeyEvent e) { }
	@Override public void keyPressed(KeyEvent e) { }
	@Override public void keyReleased(KeyEvent e) { }

//	@formatter:on

}