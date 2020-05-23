package gui;

import data.Node;
import logic.Parsable;

public enum Interaction implements Interactive {

	BRACKET_IN {
		@Override
		public void interact(Button button) {

		}
	},

	BRACKET_OUT {
		@Override
		public void interact(Button button) {

		}
	},

	ADD_TO_PARSER {
		@Override
		public void interact(Button button) {
			System.out.println(button.getSymbol());
//			Parsable.addToParserCache(button.getSymbol());
		}
	},

	SWITCH_SIGN {
		@Override
		public void interact(Button button) {
			Parsable.toggleSign();
		}
	},

	ADD_TO_QUEUE {
		@Override
		public void interact(Button button) {
			Node.mainQueue.add(new Node(Parsable.dumpParserCache()));
			Node.mainQueue.add(new Node(button.getType()));
		}
	},

	SOLVE {
		@Override
		public void interact(Button button) {
			Node.mainQueue.add(new Node(Parsable.dumpParserCache()));
			if (!Node.mainQueue.isEmpty())
				((Node) Node.mainQueue).convertToTree();
		}
	},
	UNDO {
		@Override
		public void interact(Button button) {
		}
	},

	CLEAR {
		@Override
		public void interact(Button button) {

		}
	},
	RESET {
		@Override
		public void interact(Button button) {

		}
	},
	EMPTY {
		@Override
		public void interact(Button button) {

		}
	}

}
