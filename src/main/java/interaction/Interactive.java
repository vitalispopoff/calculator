package interaction;

import gui.MainPanel;
import logic.Type;

public interface Interactive {

	static void interactWithOutput(Interactive action) {
		MainPanel.displayUpdate();
		action.interactWithOutput();
	}

	default void interactWithOutput(){}
	default void interactWithData(Whatevah whatevah){}


	class Whatevah {

//		@formatter:off

		public Type
				type = null;
		public char
				symbol;

		public Whatevah(Type type, char symbol) {
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