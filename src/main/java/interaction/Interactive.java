package interaction;

import gui.MainPanel;
import logic.Type;

public interface Interactive {

	static void interactWithOutput(Interactive action) {
		MainPanel.topDisplayUpdate();
		action.interactWithOutput();

	}

	default void interactWithOutput(){}
	default void interactWithData(ButtonDetails buttonDetails){}

	class ButtonDetails {

//		@formatter:off

		public Type
				type = null;
		public char
				symbol;

		public ButtonDetails(Type type, char symbol) {
			this.type = type;
			this.symbol = symbol;
		}

		public Type getType() { return type; }
		public char getSymbol() { return symbol; }

		public void setType(Type type) { this.type = type; }
		public void setSymbol(char symbol) { this.symbol = symbol; }

//		@formatter:on

	}
}