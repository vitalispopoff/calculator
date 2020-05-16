package data;

public interface Enqueued extends Queueable, Treeable {

//	@formatter:off

	@Override void setPrev (Queueable queueable);
	@Override void setPost (Queueable queueable);

	@Override Queueable getPrev ();
	@Override Queueable getPost ();

	@Override default void setHead (Queueable queueable) { setPrev (queueable); }
	@Override default void setTail (Queueable queueable) { setPost (queueable); }

	@Override default Queueable getHead () { return getPrev (); }
	@Override default Queueable getTail () { return getPost (); }

//	@formatter:on

}