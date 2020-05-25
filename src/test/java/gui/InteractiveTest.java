package gui;

import data.Node;
import interaction.Interaction;
import logic.Parsable;

import static logic.Type.*;

public class InteractiveTest {


}

class Main {


	public static void main(String[] args) {

		Button
				b1 = new Button(Interaction.ADD_TO_PARSER, VALUE, '1'),
				b2 = new Button(Interaction.SWITCH_SIGN, VALUE, '.'),
				b3 = new Button(Interaction.ADD_TO_PARSER, VALUE, '0'),
				b4 = new Button(Interaction.ADD_TO_QUEUE, ADD, '+'),
				b5 = b3,
				b6 = b2,
				b7 = b1,
				bN = new Button(Interaction.SOLVE, EVALUATE, '=');

		Parsable.resetParsableCache();
		Node.resetMainQueue();

//		b1.action






	}


}
