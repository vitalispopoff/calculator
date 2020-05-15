package data;

public interface Queueable {

//	@formatter:off

	void setHead (Queueable queueable);
	void setTail (Queueable queueable);

	Queueable getHead ();
	Queueable getTail ();

//	defaults  \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	default void add (Queueable queueable) {

		if (isHollow ()) {
			setHead (queueable);
		}
		else {
			queueable.setHead (getTail ());
			getTail ().setTail (queueable);
		}
		setTail (queueable);
	}

	default Queueable remove () {

		Queueable
				cache = null;

		if (! isHollow ()) {
			cache = getHead();

			if (isSingle ()) {
				setHead (null);
				setTail (null);
			}
			else {
				setHead (getHead ().getTail () );
				getHead ().setHead (null);
				cache.setTail (null);
			}
		}
		return cache;
	}

	default boolean isHollow () {
		return getHead () == null;
	}
	default boolean isSingle () {
		return getHead () == getTail () && ! isHollow ();
	}

//	@formatter:on

}