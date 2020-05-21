package data;

import logic.Type;

public interface Queueable {

//	@formatter:off

	default void add(Queueable q){
		if(isEmpty()){
			setHead(q);
//			setTail(q);
		} else {
			q.setPrev(getTail());
			q.getPrev().setNext(q);
		}
		setTail(q);
		addType(q.getType());
	}
	default void remove(Queueable q){
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
	default boolean isMultiPiece(){return !isEmpty() && !isOnePiece();}

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
	int getCurrentType();

//	@formatter:on

}