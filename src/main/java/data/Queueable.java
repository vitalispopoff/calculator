package data;

public interface Queueable {

	static final Queueable mainQueueable = new MainQueue();


//	@formatter:off

	void setHead (Queueable queueable);
	void setTail (Queueable queueable);

	Queueable getHead ();
	Queueable getTail ();

//	static  //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	static boolean isMainQueueableEmpty(){return true;}
	static void addToMainQueueable(Queueable queueable){ mainQueueable.add(queueable);}

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

	default boolean isHollow () { return getHead () == null; }
	default boolean isSingle () { return getHead () == getTail () && ! isHollow (); }

//	Queueable implementation  \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	class MainQueue implements Queueable {

		Queueable
				head = null,
				tail = null;

		@Override public void setHead (Queueable queueable) { head = queueable; }
		@Override public void setTail (Queueable queueable) { tail = queueable; }

		@Override public Queueable getHead() {
			return head;
		}
		@Override public Queueable getTail() {
			return tail;
		}
	}

//	@formatter:on

}