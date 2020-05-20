package data;

import logic.Solvable;
import logic.Type;

public class Node implements /*Queueable,*/ Solvable, Treeable {

//	@formatter:off

	static Queueable mainQueue = new Node();

	int[]
			typeIndex = new int[Type.values().length >> 1];
	Double
			value = Double.NaN;
	Type
			type = null;
	Queueable
			left = null,
			rite = null,
			prev = null,
			next = null;



//	Queueable \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override public void setHead(Queueable q) { setLeft(q); }
	@Override public void setTail(Queueable q) { setRite(q); }
	@Override public void setPrev(Queueable q) { prev = q; }
	@Override public void setNext(Queueable q) { next = q; }

	@Override public double getValue() { return value; }
	@Override public Type getType() { return type; }

	@Override public Queueable getHead() { return getLeft(); }
	@Override public Queueable getTail() { return getRite(); }
	@Override public Queueable getPrev() { return prev; }
	@Override public Queueable getNext() { return next; }

	@Override public void setValue(double v) { value = v; }
	@Override public void setValue() {
		int
				thisIndexNumber = getType().ordinal()>>1,
				valueIndexNumber = Type.VALUE.ordinal()>>1,
				bracketIndexNumber = Type.BRACKET_OUT.ordinal()>>1;

		if (thisIndexNumber < valueIndexNumber && thisIndexNumber > bracketIndexNumber
				&& this.getHead().getType() == Type.VALUE && this.getTail().getType() == Type.VALUE)
			setValue(solve(this.getHead().getValue(), this.getTail().getValue()));

	}
	@Override public void setType(Type t) {type = t;}

	@Override public void addType(Type t) { typeIndex[t.ordinal()>>1]++; }
	@Override public void removeType(Type t) {
		if(typeIndex[t.ordinal()>>1]>0)
			typeIndex[t.ordinal()>>1]--;
	}

//	Solvable  \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override
	public double solve(double leftValue, double riteValue) { return type.solve(leftValue, riteValue); }

//	Treeable  \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override public void setLeft(Queueable q){left = q;}
	@Override public void setRite(Queueable q){rite = q;}
	@Override public Queueable getLeft(){return left;}
	@Override public Queueable getRite(){return rite;}

	@Override
	public void convertToTree() {

	}

/*	@Override
	public Queueable convertToLocalTree() {

		Queueable
				localLeft = this,
				localRoot = getNext(),
				localRite = getNext().getNext();

		if (localLeft.getPrev() != null)
			localLeft.getPrev().setNext(localRoot);

		if (localRite.getNext() != null)
			localRite.getNext().setPrev(localRoot);

		localRoot.setTail(localRite);
		localRoot.setNext(localRite.getNext());

		localRite.setNext(null);
		localLeft.setPrev(null);

		localRoot.setPrev(localLeft.getPrev());
		localRoot.setHead(localLeft);

		return localRoot;
	}*/	// ? disposable ?

	//	@formatter:on

}
