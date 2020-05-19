package data;

//	@formatter:off

public interface Nodeable extends Enqueued, Treeable {

//	Treeable  \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override void setLeft (Queueable queueable);
	@Override void setRite (Queueable queueable);
	@Override void setRoot (Queueable queueable);

	@Override Queueable getLeft ();
	@Override Queueable getRite ();
	@Override Queueable getRoot ();

	@Override Queueable convertToLocalTree();

//	Enqueued implementation //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override default void setPost (Queueable queueable) { setRoot (queueable); }

	@Override default Queueable getPrev () { return getLeft() == getRite () ? getLeft () : null; }
	@Override default Queueable getPost () { return getRoot (); }

//	empty overrides //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override default void setPrev (Queueable queueable) {}
	@Override default void addType (Queueable queueable) {}
	@Override default void removeType (Queueable queueable) {}

//	@formatter:on

}