package data;

public interface Nodeable extends Enqueued, Treeable{

//	@formatter:off

	static  void convertToLocalTree(Queueable queueable){}

//	Treeable implementation //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override void setLeft (Queueable queueable);
	@Override void setRite (Queueable queueable);
	@Override void setRoot (Queueable queueable);

	@Override Queueable getLeft ();
	@Override Queueable getRite ();
	@Override Queueable getRoot ();

//	Enqueued implementation //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override default void setPrev (Queueable queueable) {
		setLeft (queueable);
		setRite (queueable);
	}
	@Override default void setPost (Queueable queueable) { setRoot (queueable); }

	@Override default Queueable getPrev () { return getLeft() == getRite () ? getLeft () : null; }
	@Override default Queueable getPost () { return getRoot (); }

//	@formatter:on

}