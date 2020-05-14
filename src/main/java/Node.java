public class Node implements Nodeable {

	static final Nodeable empty = null;

	static Nodeable
			mainQueue = new Node(empty);


	int[] priorityIndex = new int[Priority.values().length];
	Nodeable
			left = empty,
			rite = empty,
			root = empty;
	Double
			value = Double.NaN;
	Priority
			priorityType = null;

	Node(Nodeable nodeable) {
		setRoot(nodeable);
		if (nodeable != empty || nodeable != null) addToPriorityIndex(nodeable);
	}

	Node(Priority type) {priorityType = type; }

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	void addToPriorityIndex(Nodeable nodeable) {
		int
				index = ((Node) nodeable).priorityType.ordinal() >> 1;
		priorityIndex[index]++;
	}

	void takeFromPriorityIndex(Nodeable nodeable) {
		int
				index = ((Node) nodeable).priorityType.ordinal() >> 1;
		if (priorityIndex[index] > 0) priorityIndex[index]--;
	}

	public Nodeable takeFromQueue() {
		Nodeable
				cache = mainQueue.getLeft();


		/*
		mainQueue.setLeft(cache.getRoot());

		if (mainQueue.getLeft() == null) mainQueue.setRite(null);
		cache.setRoot(null);
		((Node) mainQueue).takeFromPriorityIndex(cache);
*/

		return cache;
	}

	public void addToQueue(Nodeable nodeable) {
		if (getLeft() == null || getLeft() == empty) setLeft(nodeable);
		if (getRite() != null) getRite().setRoot(nodeable);

		setRite(nodeable);

		((Node) mainQueue).addToPriorityIndex(nodeable);
	}

//	getters & setters \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	void setValue(Double value) { this.value = value; }

	Double getValue() { return value; }

	int getPriorityIndex() {
		if (this == mainQueue) {
			int index = 0;

			for (int i : priorityIndex) {
				if (i == 0) index++;
				else return index;
			}
			return index;
		}
		else return priorityType.ordinal() >> 1;
	}

//	 @Overrides //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override
	public Nodeable getLeft() { return left; }

	@Override
	public Nodeable getRite() { return rite; }

	@Override
	public Nodeable getRoot() { return root; }

	@Override
	public void setLeft(Nodeable nodeable) { left = nodeable; }

	@Override
	public void setRite(Nodeable nodeable) { rite = nodeable; }

	@Override
	public void setRoot(Nodeable nodeable) { root = nodeable; }
}