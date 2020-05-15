public interface Enqueued extends Queueable {

//	@formatter:off

	void setPrev (Enqueued enqueued);
	void setPost (Enqueued enqueued);

	Enqueued getPrev ();
	Enqueued getPost ();

//	Overrides \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override default void setHead (Queueable queueable) { setPrev( (Enqueued) queueable); }
	@Override default void setTail (Queueable queueable) { setPost( (Enqueued) queueable); }

	@Override default Queueable getHead () { return (Queueable) getPrev (); }
	@Override default Queueable getTail () { return (Queueable) getPost (); }

//	@formatter:on

}