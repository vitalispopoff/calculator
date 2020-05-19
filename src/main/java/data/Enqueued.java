package data;

import logic.Type;

public interface Enqueued extends Queueable{

//	@formatter:off

	void setPrev (Queueable queueable);
	void setPost (Queueable queueable);

	Queueable getPrev ();
	Queueable getPost ();

	static void deQueue (Queueable queueable){}

	@Override default void setHead (Queueable queueable) { setPrev (queueable); }
	@Override default void setTail (Queueable queueable) { setPost (queueable); }

	@Override default Queueable getHead () { return getPrev (); }
	@Override default Queueable getTail () { return getPost (); }

	@Override default int getTypeIndex(){return Type.values().length;}

//	@formatter:on

}