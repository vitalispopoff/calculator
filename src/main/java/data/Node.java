package data;

import logic.Type;

public class Node implements Nodeable {

//	@formatter:off

	Queueable
			left = null,
			rite = null,
			root = null;
	Type
			type = null;
	Double
			value = Double.NaN;

	Node (Queueable queueable) {
		setLeft (queueable);
		setRite (queueable);
	}

	public Double getValue () { return value; }

	public void setType (Type type) { this.type = type; }
	public void setValue (Double value) { this.value = value; }

	@Override public Type getType() { return type; }
	@Override public void addType(Queueable queueable) {}
	@Override public void removeType(Queueable queueable) {}

	@Override public void setLeft (Queueable queueable) { left = queueable; }
	@Override public void setRite (Queueable queueable) { rite = queueable; }
	@Override public void setRoot (Queueable queueable) { root = queueable; }

	@Override public Queueable getLeft () { return left; }
	@Override public Queueable getRite () { return rite; }
	@Override public Queueable getRoot () { return root; }

	//	@formatter:on

	@Override
	public double solve(/*double operand1, double operand2*/) {
		double
				operand1 = ((Node) getLeft()).getValue(),
				operand2 = ((Node) getRite()).getValue();


		return 0;
	}
}