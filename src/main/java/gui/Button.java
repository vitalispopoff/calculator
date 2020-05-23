package gui;

import logic.Type;

import javax.swing.*;

import static gui.Settings.buttonRowLength;

public class Button extends JButton /*implements KeyListener*/ {

	public Type
			type = null;
	public char
			symbol;

	public Button(Interactive action, char symbol) {
		setNameAndText(symbol);
		addActionListener(e ->action.interact(this));
		System.out.println("button "+symbol);
	}
	public Button(Interactive action, Type type, char symbol) {
		setNameAndText(symbol);
		setType(type);
		addActionListener(e ->action.interact(this));
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

	void setNameAndText(char symbol) {
		setName("button_" + symbol);
		setText(Character.toString(symbol));
	}
	void setType(Type type) { this.type = type; }
//	void setAction(Interactive action){this.action = action;}

	public char getSymbol() { return symbol; }
	public Type getType() { return type; }

//	KeyListener implementation  //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

//	@Override public void keyTyped(KeyEvent e) { }
//	@Override public void keyPressed(KeyEvent e) { }
//	@Override public void keyReleased(KeyEvent e) { }

//	@formatter:on

}