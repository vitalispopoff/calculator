package interaction;

import data.Node;
import gui.MainPanel;
import logic.Parsable;

public enum Interaction implements Interactive {

	BRACKET_IN,
	BRACKET_OUT,
	ADD_TO_PARSER {
		@Override
		public void interactWithData(ButtonDetails buttonDetails) { Parsable.addToParserCache(buttonDetails.getSymbol()); }
	},
	SWITCH_SIGN {
		@Override
		public void interactWithData(ButtonDetails buttonDetails) { Parsable.toggleSign(); }
	},
	ADD_TO_QUEUE {
		@Override
		public void interactWithData(ButtonDetails buttonDetails) {
			Node.mainQueue.add(new Node(Parsable.dumpParserCache()));
			Node.mainQueue.add(new Node(buttonDetails.getType(), buttonDetails.getSymbol()));
		}
	},
	SOLVE {
		@Override
		public void interactWithData(ButtonDetails buttonDetails) {
			Node.mainQueue.add(new Node(Parsable.dumpParserCache()));
			if (!Node.mainQueue.isEmpty())
				((Node) Node.mainQueue).convertToTree();
		}

		@Override
		public void interactWithOutput() {
			double
					result = Node.mainQueue.getHead().getNumberValue();
			String
					resultString = Double.toString(result);

			MainPanel.bottomDisplayUpdate(resultString);
			Node.encloseContent();
		}
	},
	UNDO,
	CLEAR {
		@Override
		public void interactWithOutput(){
			Node.resetContent();
			Node.resetMainQueue();
			Parsable.resetParsableCache();
			if (Double.valueOf(MainPanel.bottomDisplay.getText()) != 0.) {
				MainPanel.bottomDisplay.setText("0.");
				MainPanel.topDisplay.setText("0.");
			}
		}

	},
	RESET,
	EMPTY
}