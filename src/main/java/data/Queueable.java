package data;

import logic.Type;

public interface Queueable {

//	@formatter:off

	default void add(Queueable q){
		if(isEmpty()){
			setHead(q);
		} else {
			q.setPrev(getTail());
			q.getPrev().setNext(q);
		}
		setTail(q);
		addType(q.getType());
	}
	default boolean isEmpty(){
		return getHead() == getTail() && getHead() == null;
	}
	default boolean isOnePiece(){
		return getHead() == getTail() && getHead() != null;
	}
	default boolean isMultiPiece(){return !isEmpty() && !isOnePiece();}

	Queueable getHead();
	Queueable getTail();
	Queueable getPrev();
	Queueable getNext();

	double getNumberValue();
	Type getType();

	void setHead(Queueable q);
	void setTail(Queueable q);
	void setPrev(Queueable q);
	void setNext(Queueable q);

	void setNumberValue(double v);
	void setValue(Queueable q);
	void setType(Type t);

	void addType(Type type);
	void removeType(Type type);
	int getCurrentType();

//	@formatter:on

}