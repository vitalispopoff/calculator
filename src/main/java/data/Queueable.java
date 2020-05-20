package data;

import logic.Type;

public interface Queueable {

	default void addQueueable(Queueable q){
		getTail().setNext(q);
		q.setPrev(getTail());
		setTail(q);
		addType(q.getType());
	}
	default void removeQueueable(Queueable q){
		if (getHead() == q ){
			setHead(q.getNext());
			getHead().setPrev(null);
			q.setNext(null);

		}
		else if (getTail() == q){
			setTail(q.getPrev());
			getTail().setNext(null);
			q.setPrev(null);
		}
		else {
			q.getPrev().setNext(q.getNext());
			q.getNext().setPrev(q.getPrev());
			q.setPrev(null);
			q.setNext(null);
		}
		removeType(q.getType());

	}
	default boolean isEmpty(){
		return getHead() == getTail() && getHead() == null;}
	default boolean isOnePiece(){
		return getHead() == getTail() && getHead() != null;
	}

	Queueable getHead();
	Queueable getTail();
	Queueable getPrev();
	Queueable getNext();

	double getValue();
	Type getType();

	void setHead(Queueable q);
	void setTail(Queueable q);
	void setPrev(Queueable q);
	void setNext(Queueable q);

	void setValue(double v);
	void setValue();
	void setType(Type t);

	void addType(Type type);
	void removeType(Type type);

}