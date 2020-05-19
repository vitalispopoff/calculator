package data;

import logic.Type;

public class Queue extends Queueable.MainQueue {

	static Type[] typeIndex =new Type[Type.values().length>>1];

//	@formatter:off

	Queue () { }
	Queue (Queueable queueable) {
			setHead (queueable);
			setTail (queueable);
	}

//	@formatter:on

}