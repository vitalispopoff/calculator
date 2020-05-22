package gui;

public enum Interaction implements Interactive {


	BRACKET_IN {
		@Override
		public void interact() {System.out.println("pushed \'(=)\' button");}

	},
	BRACKET_OUT {
		@Override
		public void interact() {}

	},

	ADD_TO_PARSER {
		@Override
		public void interact() {}

	},
	SWITCH_SIGN {
		@Override
		public void interact() {System.out.println("pushed \'=\' button");}

	},

	SOLVE {
		@Override
		public void interact() {}

	},
	UNDO {
		@Override
		public void interact() {}

	},

	CLEAR {
		@Override
		public void interact() {}

	},
	RESET {
		@Override
		public void interact() {}

	},
	EMPTY {
		@Override
		public void interact() {}
	}
}
