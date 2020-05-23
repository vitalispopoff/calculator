package data;

import logic.Solvable;
import logic.Type;

public class Node implements Solvable, Treeable {

//	@formatter:off

	public static Queueable
			mainQueue = new Node();
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

	Node(){}
	public Node(Double value){
		setType(Type.VALUE);
		setValue(value);
	}
	public Node(Type type){
		setType(type);
	}

	static public void resetMainQueue(){
		mainQueue.setHead(null);
		mainQueue.setTail(null);
		((Node)mainQueue).typeIndex = new int[Type.values().length >> 1];
		mainQueue.setValue(Double.NaN);
		mainQueue.setType(null);
	}

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
	@Override public void setValue(Queueable q) {
		int
				qIndex = q.getType().ordinal()>>1,
				valueIndex = Type.VALUE.ordinal()>>1,
				bracketIndex = Type.BRACKET_OUT.ordinal()>>1;

		if (qIndex < valueIndex && qIndex > bracketIndex) {
			double
					leftValue = q.getHead().getValue(),
					riteValue = q.getTail().getValue(),
					thisValue = ((Node) q).solve(leftValue, riteValue);
			q.setValue(thisValue);
		}
		removeType(q.getType());
		q.setType(Type.VALUE);
		addType(q.getType());
	}
	@Override public void setType(Type t) {type = t;}

	@Override public void addType(Type t) { typeIndex[t.ordinal()>>1]++; }
	@Override public void removeType(Type t) {
		if(typeIndex[t.ordinal()>>1]>0)
			typeIndex[t.ordinal()>>1]--;
	}
	@Override public int getCurrentType(){
		int result = 0;

		for (int index : typeIndex) {
			if (index == 0) result++;
			else return result;
		}
		return typeIndex.length;
	}

//	Solvable  \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override public double solve(double leftValue, double riteValue) { return type.solve(leftValue, riteValue); }

//	Treeable  \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override public void setLeft(Queueable q){left = q;}
	@Override public void setRite(Queueable q){rite = q;}
	@Override public Queueable getLeft(){return left;}
	@Override public Queueable getRite(){return rite;}

	//	@formatter:on

	@Override
	public void convertToTree() {
		Queueable
				localCache = mainQueue.getHead();

		while (mainQueue.isMultiPiece()) {
			localCache = priorityCheck(localCache);
			if (localCache == null) break;
			else {
				localCache = convertToLocalTree(localCache);
				setValue(localCache);
			}
			// ! dispatch the local tree
		}
		setValue(getHead().getValue());
	}


}