package data;

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

//	getters & setters \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	public Type getType () { return type; }
	public Double getValue () { return value; }

	public void setType (Type type) { this.type = type; }
	public void setValue (Double value) { this.value = value; }

//	Overrides \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override public void setLeft (Queueable queueable) { left = queueable; }
	@Override public void setRite (Queueable queueable) { rite = queueable; }
	@Override public void setRoot (Queueable queueable) { root = queueable; }

	@Override public Queueable getLeft () { return left; }
	@Override public Queueable getRite () { return rite; }
	@Override public Queueable getRoot () { return root; }

	//	@formatter:on

}