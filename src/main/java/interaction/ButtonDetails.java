//		@formatter:off

package interaction;

import logic.Type;

public class ButtonDetails {

	public Type
			type = null;
	public char
			symbol;

	public ButtonDetails(Type type, char symbol) {

		this.type = type;
		this.symbol = symbol;
	}

	public Type getType() { return type; }
	public void setType(Type type) { this.type = type; }

	public char getSymbol() { return symbol; }
	public void setSymbol(char symbol) { this.symbol = symbol; }
}

//		@formatter:on