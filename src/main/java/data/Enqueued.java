package data;

public interface Enqueued extends Queueable {

//	@formatter:off

	void setPrev (Queueable queueable);
	void setPost (Queueable queueable);

	Queueable getPrev ();
	Queueable getPost ();

//	Queueable implementation  \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override default public Queueable remove(){
		Queueable
				localCache1 = getPrev(),
				localCache2 = getPost();
		((Enqueued)getPrev()).setPost(getPost());



		return null;
	}

	@Override int getTypeIndex();

	@Override default void setHead (Queueable queueable) { /*setPrev (queueable);*/ }
	@Override default void setTail (Queueable queueable) { setPost (queueable); }

	@Override default Queueable getHead () { return null/*getPrev ()*/; }
	@Override default Queueable getTail () { return getPost (); }

//	@formatter:on

}