package data;

import logic.Type;

public class Node implements Nodeable {

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

	//	@formatter:on

	public double solve() {
		double
				operand1 = ((Node) getLeft()).getValue(),
				operand2 = ((Node) getRite()).getValue();
		return type.solve(operand1, operand2);
	}

	@Override
	public void convertToLocalTree() {


	}
}