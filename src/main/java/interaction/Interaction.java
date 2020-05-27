package interaction;

import data.Node;
import gui.MainPanel;
import logic.Parsable;

public enum Interaction implements Interactive {

	BRACKET_IN {
		@Override
		public void interact(Whatevah whatevah) {
		};
		public void dupa(){System.out.println(this);}
	},

	BRACKET_OUT {
		@Override
		public void interact(Whatevah whatevah) {
		};
		public void dupa(){System.out.println(this);}
	},

	ADD_TO_PARSER {
		@Override
		public void interact(Whatevah whatevah) {
			Parsable.addToParserCache(whatevah.getSymbol());
		}
		public void dupa(){
			MainPanel.displayUpdate();
		}
	},

	SWITCH_SIGN {
		@Override
		public void interact(Whatevah whatevah) {
			Parsable.toggleSign();
		}
		public void dupa(){System.out.println(this);}
	},

	ADD_TO_QUEUE {
		@Override
		public void interact(Whatevah whatevah) {
			Node.mainQueue.add(new Node(Parsable.dumpParserCache()));
			Node.mainQueue.add(new Node(whatevah.getType(), whatevah.getSymbol()));
		}
		public void dupa(){System.out.println(this);}
	},

	SOLVE {
		@Override
		public void interact(Whatevah whatevah) {
			Node.mainQueue.add(new Node(Parsable.dumpParserCache()));
			if (!Node.mainQueue.isEmpty())
				((Node) Node.mainQueue).convertToTree();
		}
		public void dupa(){System.out.println(this);}
	},
	UNDO {
		@Override
		public void interact(Whatevah whatevah) {
		}
		public void dupa(){System.out.println(this);}
	},

	CLEAR {
		@Override
		public void interact(Whatevah whatevah) {
		}
		public void dupa(){System.out.println(this);}
	},
	RESET {
		@Override
		public void interact(Whatevah whatevah) {
		}
		public void dupa(){System.out.println(this);}
	},
	EMPTY {
		@Override
		public void interact(Whatevah whatevah) {
		}
		public void dupa(){System.out.println(this);}
	};

//	static public void dupa(Interactive action){action.dupa();}

}