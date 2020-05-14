public class Queue implements Queueable {

	Queueable
			head = null,
			tail = null;

	Queue(){}

	Queue(Queueable queueable){
			setHead(queueable);
			setTail(queueable);
	}


//	@Overrides  //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override
	public void setHead(Queueable queuer) { this.head = queuer; }

	@Override
	public void setTail(Queueable queuer) { this.tail = queuer; }

	@Override
	public Queueable getHead() { return head; }

	@Override
	public Queueable getTail() { return tail; }
}