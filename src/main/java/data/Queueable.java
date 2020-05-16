package data;

public interface Queueable {

	static final Queueable mainQueueable = new Queue1();


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

	class Queue1 implements Queueable {

		Queueable
				head = null,
				tail = null;

		@Override public void setHead (Queueable queueable) { head = queueable; }
		@Override public void setTail (Queueable queueable) { tail = queueable; }

		@Override public Queueable getHead() {
			return null;
		}
		@Override public Queueable getTail() {
			return null;
		}
	}

//	@formatter:on

}