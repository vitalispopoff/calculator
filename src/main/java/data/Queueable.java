//	@formatter:off

package data;

import logic.Type;

public interface Queueable {

	Queueable getHead();
	void setHead(Queueable q);

	Queueable getTail();
	void setTail(Queueable q);

	Queueable getPrev();
	void setPrev(Queueable q);

	Queueable getNext();
	void setNext(Queueable q);

	double getNumberValue();
	void setNumberValue(double v);

	void setValue(Queueable q);

	Type getType();
	void setType(Type t);

	void addType(Type type);

	void removeType(Type type);

	int getCurrentType();

//	--------------------------------------------------------------------------------------------------------------------

	default void add(Queueable q){

		if(isEmpty()){
			setHead(q);
		}

		else {

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

	default boolean isMultiPiece(){

		return !isEmpty() && !isOnePiece();
	}
}

//	@formatter:on