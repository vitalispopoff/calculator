package interaction;

import data.Node;
import gui.MainPanel;
import logic.Parsable;


public enum Interaction implements Interactive {

	BRACKET_IN ,
	BRACKET_OUT,

	ADD_TO_PARSER {@Override public void interactWithData(Whatevah whatevah) { Parsable.addToParserCache(whatevah.getSymbol()); }},

	SWITCH_SIGN {
		@Override public void interactWithData(Whatevah whatevah) { Parsable.toggleSign(); }
		@Override public void interactWithOutput(){ MainPanel.displayUpdate(); }
	},

	ADD_TO_QUEUE {
		@Override
		public void interactWithData(Whatevah whatevah) {
			Node.mainQueue.add(new Node(Parsable.dumpParserCache()));
			Node.mainQueue.add(new Node(whatevah.getType(), whatevah.getSymbol()));
		}
	},

	SOLVE {
		@Override
		public void interactWithData(Whatevah whatevah) {
			Node.mainQueue.add(new Node(Parsable.dumpParserCache()));
			if (!Node.mainQueue.isEmpty())
				((Node) Node.mainQueue).convertToTree();
		}
	},

	UNDO,
	CLEAR,
	RESET,
	EMPTY
}