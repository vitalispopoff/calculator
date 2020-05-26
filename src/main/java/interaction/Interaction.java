package interaction;

import data.Node;
import logic.Parsable;

public enum Interaction implements Interactive {

	BRACKET_IN {
		@Override
		public void interact(Whatevah whatevah) {
		}
	},

	BRACKET_OUT {
		@Override
		public void interact(Whatevah whatevah) {
		}
	},

	ADD_TO_PARSER {
		@Override
		public void interact(Whatevah whatevah) {
			Parsable.addToParserCache(whatevah.getSymbol());
		}
	},

	SWITCH_SIGN {
		@Override
		public void interact(Whatevah whatevah) {
			Parsable.toggleSign();
		}
	},

	ADD_TO_QUEUE {
		@Override
		public void interact(Whatevah whatevah) {
			Node.mainQueue.add(new Node(Parsable.dumpParserCache()));
			Node.mainQueue.add(new Node(whatevah.getType(), whatevah.getSymbol()));
		}
	},

	SOLVE {
		@Override
		public void interact(Whatevah whatevah) {
			Node.mainQueue.add(new Node(Parsable.dumpParserCache()));
			if (!Node.mainQueue.isEmpty())
				((Node) Node.mainQueue).convertToTree();
		}
	},
	UNDO {
		@Override
		public void interact(Whatevah whatevah) {
		}
	},

	CLEAR {
		@Override
		public void interact(Whatevah whatevah) {

		}
	},
	RESET {
		@Override
		public void interact(Whatevah whatevah) {

		}
	},
	EMPTY {
		@Override
		public void interact(Whatevah whatevah) {

		}
	}

}
