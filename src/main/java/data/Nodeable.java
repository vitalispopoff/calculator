package data;

public interface Nodeable extends Enqueued{

//	@formatter:off

	void setLeft (Queueable queueable);
	void setRite (Queueable queueable);
	void setRoot (Queueable queueable);

	Queueable getLeft ();
	Queueable getRite ();
	Queueable getRoot ();

//	@Overrides  //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override default void setPrev (Queueable queueable) {
		setLeft ( queueable);
		setRite ( queueable);
	}
	@Override default void setPost (Queueable queueable) { setRoot ( queueable); }

	@Override default Queueable getPrev () { return getLeft() == getRite () ? getLeft () : null; }
	@Override default Queueable getPost () { return getRoot (); }

//	@formatter:on
}