import logic.Solvable;

public class Queue implements Queueable, Solvable {

//	@formatter:off

	Queueable
			head = null,
			tail = null;

	Queue () { }
	Queue (Queueable queueable) {
			setHead (queueable);
			setTail (queueable);
	}

//	Overrides \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override public void setHead (Queueable queueable) { this.head = queueable; }
	@Override public void setTail (Queueable queueable) { this.tail = queueable; }

	@Override public Queueable getHead () { return head; }
	@Override public Queueable getTail () { return tail; }

	@Override public String solve(){return "";}

//	@formatter:on

}