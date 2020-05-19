package data;

import logic.Type;

public class Node /*implements Nodeable*/ implements Queueable {

	Queueable
			head = null,
			tail = null,
			prev = null,
			next = null;
	Type type = null;
	Double value = Double.NaN;

//	@formatter:off

	@Override public void setHead(Queueable q) { head = q; }
	@Override public void setTail(Queueable q) { tail = q; }
	@Override public void setPrev(Queueable q) { prev = q; }
	@Override public void setNext(Queueable q) { next = q; }

	@Override public Queueable getHead() { return head; }
	@Override public Queueable getTail() { return tail; }
	@Override public Queueable getPrev() { return prev; }
	@Override public Queueable getNext() { return next; }

	@Override public Type getType() { return type; }
	@Override public double getValue() { return value; }

	@Override public void setType(Type t) {type = t;}
	@Override public void setValue(double v) { value = v; }

	@Override public void setValue() {

	}

	@Override public void addType(Type t) {

	}

	@Override public void removeType(Type t) {

	}

	@Override public boolean isEmpty() {
		return false;
	}

	@Override public boolean isOnePiece() {
		return false;
	}

	//	@formatter:on


/*
//	@formatter:off

	Queueable left,rite, root;
	Type
			type = null;
	Double
			value = Double.NaN;

	Node() { left = rite = root = null; }

	public void setType (Type type) { this.type = type; }
	public void setValue (Double value) {this.value = value;}
	public void setValue () {
		if (((Node) left).getValue() != null && ((Node) rite).getValue() != null)
			setValue(solve());
	}

	public Double getValue () { return value; }

	@Override public Type getType () { return type; }

	@Override public void setLeft (Queueable queueable) { left = queueable; }
	@Override public void setRite (Queueable queueable) { rite = queueable; }
	@Override public void setRoot (Queueable queueable) { root = queueable; }

	@Override public Queueable getLeft () { return left; }
	@Override public Queueable getRite () { return rite; }
	@Override public Queueable getRoot () { return root; }

	@Override public int getTypeIndex(){return getType().ordinal()>>1;}

	@Override public Queueable convertToLocalTree() {
		Nodeable
				localRoot = (Nodeable) getRoot(),
				localRite = (Nodeable) localRoot.getRoot();

		localRoot.setLeft(this);
		localRoot.setRite(localRite);
		localRoot.setRoot(localRite.getRoot());
		localRite.setRoot(null);	// ? it may also be localRoot - what's better ?

		return localRoot;
	}

	//	@formatter:on

	public double solve() {
		double
				operand1 = ((Node) getLeft()).getValue(),
				operand2 = ((Node) getRite()).getValue();
		return type.solve(operand1, operand2);
	}*/
}
