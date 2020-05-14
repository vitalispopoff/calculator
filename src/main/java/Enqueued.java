public interface Enqueued extends Queueable {

	void setPrev(Enqueued queuer);

	void setPost(Enqueued queuer);

	Enqueued getPrev();

	Enqueued getPost();

//	@Overrides  //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override
	default void setHead(Queueable queuer) {setPrev((Enqueued) queuer);}

	@Override
	default void setTail(Queueable queuer) {setPost((Enqueued) queuer);}

	@Override
	default Queueable getHead() {return (Queueable) getPrev();}

	@Override
	default Queueable getTail() {return (Queueable) getPost();}
}