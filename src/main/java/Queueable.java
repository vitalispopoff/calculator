public interface Queueable {

	void setHead(Queueable queuer);
	void setTail(Queueable queuer);

	Queueable getHead();
	Queueable getTail();
}