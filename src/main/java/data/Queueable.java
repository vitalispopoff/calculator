package data;

import logic.Type;

public interface Queueable {

	static final Queueable mainQueueable = new MainQueue();

//	@formatter:off

	void setHead (Queueable queueable);
	void setTail (Queueable queueable);
	void addType (Queueable queueable);
	void removeType(Queueable queueable);

	Queueable getHead ();
	Queueable getTail ();
	Type getType();
	int getTypeIndex();

//	static  //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	static boolean isMainQueueableEmpty(){return true;}
	static void addToMainQueueable(Queueable queueable){ mainQueueable.add(queueable);}

//	defaults  \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	default void add (Queueable queueable) {

		if (isEmpty ()) {
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

		if (! isEmpty ()) {
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

	default boolean isEmpty () { return getHead () == null; }
	default boolean isSingle () { return getHead () == getTail () && ! isEmpty (); }

//	Queueable implementation  \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	class MainQueue implements Queueable {

		int[]
				typeIndex = new int[Type.values().length>>1];
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

		@Override public void addType(Queueable queueable) {
			if (queueable.getType() != null)
				typeIndex[queueable.getType().ordinal() >> 1]++;
		}
		@Override public void removeType(Queueable queueable) {
			if (queueable.getType() != null && typeIndex[queueable.getType().ordinal() >> 1] > 0)
				typeIndex[queueable.getType().ordinal() >> 1]--;
		}

		@Override public Type getType(){ return Type.EVALUATE;}
		@Override public int getTypeIndex() {
			int index = 0;
			for (int slot : this.typeIndex) {
				if (slot == 0) index++;
				else return index;
			}
			return Type.values().length;
		}
	}

	//	@formatter:on

}