package gui;

import logic.Type;

public interface Interactive {

	void interact(Whatevah whatevah);

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

