public class Node implements Nodeable {

//	@formatter:off

	Nodeable
			left = null,
			rite = null,
			root = null;

	Node () { }
	Node (Nodeable node) {
		setLeft (node);
		setRite (node);
	}

//	Overrides ////\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override public void setLeft (Nodeable nodeable) { left = nodeable; }
	@Override public void setRite (Nodeable nodeable) { rite = nodeable; }
	@Override public void setRoot (Nodeable nodeable) { root = nodeable; }

	@Override public Nodeable getLeft () { return left; }
	@Override public Nodeable getRite () { return rite; }
	@Override public Nodeable getRoot () { return root; }

//	@formatter:on
}