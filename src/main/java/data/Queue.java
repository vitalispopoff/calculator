package data;

public class Queue extends Queueable.MainQueue {

//	@formatter:off

	Queue () { }
	Queue (Queueable queueable) {
			setHead (queueable);
			setTail (queueable);
	}

//	@formatter:on

}