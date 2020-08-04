package interaction;

import gui.MainPanel;

public interface Interactive {

	static void interactWithOutput(Interactive action) {

		MainPanel.topDisplayUpdate();
		action.interactWithOutput();
	}

	default void interactWithOutput(){}
	default void interactWithData(ButtonDetails buttonDetails){ }

}