package gui;

import logic.Type;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static gui.Settings.*;

public class Button extends JButton implements KeyListener {

	static boolean valueSequence = true;
	private Type type;
	private char symbol;

	public Button(Type type, char symbol){
		setName("button_"+symbol);
		setText(symbol);
		setType(type);
//		addInteraction();
	}

	void setButtonBounds(int i, int tile){
		setBounds(
				(i % buttonRowLength)* tile,
				(1 + (i / buttonRowLength)) * tile,
				tile,
				tile
		);
	}

//	private void addInteraction() { addActionListener(e -> type.interact(this));}
	void setText(char symbol){setText(Character.toString(symbol));}

	public char getSymbol(){
		String
				cache = getText();
		return cache.charAt(cache.length()-1);
	}

	@Override
	public void keyTyped(KeyEvent e) { }

	@Override
	public void keyPressed(KeyEvent e){ }

	@Override
	public void keyReleased(KeyEvent e) { }

	void setType (Type type) {this.type = type;}
	public Type getType(){return type;}
}
