package data;

public interface Nodeable extends Enqueued {

//	@formatter:off

	void setLeft (Nodeable nodeable);
	void setRite (Nodeable nodeable);
	void setRoot (Nodeable nodeable);

	Nodeable getLeft ();
	Nodeable getRite ();
	Nodeable getRoot ();

//	@Overrides  //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override default void setPrev (Enqueued enqueued) {
		setLeft ( (Nodeable) enqueued);
		setRite ( (Nodeable) enqueued);
	}
	@Override default void setPost (Enqueued enqueued) { setRoot ( (Nodeable) enqueued); }

	@Override default Enqueued getPrev () { return getLeft() == getRite () ? (Enqueued) getLeft () : null; }
	@Override default Enqueued getPost () { return (Enqueued) getRoot (); }

//	@formatter:on
}