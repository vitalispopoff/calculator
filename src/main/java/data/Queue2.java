package data;

public class Queue2 implements Queueable {

	static Queueable mainQueue = new Queue2();

//	@formatter:off

	Queueable
			head = null,
			tail = null;

	Queue2 () { }
	Queue2 (Queueable queueable) {
			setHead (queueable);
			setTail (queueable);
	}

//	Overrides \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override public void setHead (Queueable queueable) { this.head = queueable; }
	@Override public void setTail (Queueable queueable) { this.tail = queueable; }

	@Override public Queueable getHead () { return head; }
	@Override public Queueable getTail () { return tail; }

//	@Override public String solve(){return "";}

//	@formatter:on

}