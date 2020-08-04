//	@formatter:off

package data;

import logic.*;

public class Node implements Solvable, Treeable {

	static public String
			content = "";
	public static Queueable
			mainQueue = new Node();
	int[]
			typeIndex = new int[Type.values().length >> 1];
	Double
			numberValue = Double.NaN;
	Type
			type = null;
	Queueable
			left = null,
			rite = null,
			prev = null,
			next = null;

//	--------------------------------------------------------------------------------------------------------------------

	Node(){ }

	public Node(Double numberValue){

		setType(Type.VALUE);
		setNumberValue(numberValue);
		updateContent(numberValue);
	}

	public Node(Type type, char symbol){

		setType(type);
		content += symbol;
	}

//	--------------------------------------------------------------------------------------------------------------------

	static public void resetMainQueue(){

		mainQueue.setHead(null);
		mainQueue.setTail(null);

		((Node)mainQueue).typeIndex = new int[Type.values().length >> 1];

		mainQueue.setNumberValue(Double.NaN);
		mainQueue.setType(null);
	}

	static public void encloseContent(){

		content = '('+content+')';
	}

	static public void resetContent(){

		content = "";
	}

	static private void updateContent(Double numberValue){

		String
			s = (numberValue % 1. == 0.)
				? Integer.toString(numberValue.intValue())
				: Double.toString(numberValue);

		content += s;
	}

//	Queueable ----------------------------------------------------------------------------------------------------------

	@Override
	public void setHead(Queueable q) { setLeft(q); }

	@Override
	public Queueable getHead() { return getLeft(); }


	@Override
	public void setTail(Queueable q) { setRite(q); }

	@Override
	public Queueable getTail() { return getRite(); }


	@Override
	public void setPrev(Queueable q) { prev = q; }

	@Override
	public Queueable getPrev() { return prev; }


	@Override
	public void setNext(Queueable q) { next = q; }

	@Override
	public Queueable getNext() { return next; }


	@Override
	public void setNumberValue(double v) { numberValue = v; }

	@Override
	public double getNumberValue() { return numberValue; }


	@Override
	public void setType(Type t) {type = t;}

	@Override
	public Type getType() { return type; }


	@Override public void setValue(Queueable q) {

		int
			qIndex = q.getType().ordinal() >> 1,
			valueIndex = Type.VALUE.ordinal() >> 1,
			bracketIndex = Type.BRACKET_OUT.ordinal() >> 1;

		if (qIndex < valueIndex && qIndex > bracketIndex) {

			double
				leftValue = q.getHead().getNumberValue(),
				riteValue = q.getTail().getNumberValue(),
				thisValue = ((Node) q).solve(leftValue, riteValue);

			q.setNumberValue(thisValue);
		}

		removeType(q.getType());
		q.setType(Type.VALUE);
		addType(q.getType());
	}

	@Override public void addType(Type t) {

		typeIndex[t.ordinal() >> 1]++;
	}

	@Override public void removeType(Type t) {

		if(typeIndex[t.ordinal() >> 1] > 0)
			typeIndex[t.ordinal() >> 1]--;
	}

	@Override public int getCurrentType(){

		int
			result = 0;

		for (int index : typeIndex) {

			if (index == 0)
				result++;

			else
				return result;
		}

		return typeIndex.length;
	}

//	Solvable  ----------------------------------------------------------------------------------------------------------

	@Override public double solve(double op1, double op2) { return type.solve(op1, op2); }

//	Treeable  ----------------------------------------------------------------------------------------------------------

	@Override
	public void setLeft(Queueable q){left = q;}

	@Override
	public Queueable getLeft(){return left;}


	@Override
	public void setRite(Queueable q){rite = q;}

	@Override
	public Queueable getRite(){return rite;}


	@Override public void convertToTree() {

		Queueable
				localCache = mainQueue.getHead();

		while (mainQueue.isMultiPiece()) {

			localCache = priorityCheck(localCache);

			if (localCache == null)
				break;
			else {

				localCache = convertToLocalTree(localCache);
				setValue(localCache);
			}

			// ! dispatch the local tree
		}

		setNumberValue(getHead().getNumberValue());
	}

}

//	@formatter:on