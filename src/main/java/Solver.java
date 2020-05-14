abstract public class Solver {

	static Nodeable cache = Node.empty;


//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\


	static void convertToLocalTree(Nodeable node) {

/*		if (isQueueASingleItem())
			return Node.mainQueue.getLeft();

		else */
		if (!isQueueEmpty() && !isQueueASingleItem()) {
			/*Nodeable localCache;*/

			if (isNodeAPriority(node) && isNodeAnOperator(cache))
				constructLocalTree(node);

			else if (isNodeAnOperator(node))
				updateCache(node);

			if (node == Node.mainQueue.getRite())
				convertToLocalTree(Node.mainQueue.getLeft());
			else
				convertToLocalTree(node.getRoot());
		}
		/*return Node.empty;*/
	}


	static Nodeable constructLocalTree(Nodeable node) {
		node.setLeft(cache.getRoot());
		cache.setRoot(node);

		node.setRite(node.getRoot());
		node.setRoot(node.getRite().getRoot());
		node.getRite().setRoot(node);

		((Node)Node.mainQueue).takeFromPriorityIndex(node);
		((Node)node).priorityType = Priority.VALUE;
		((Node)Node.mainQueue).addToPriorityIndex(node);


		return node;
	}

	static void updateCache(Nodeable node) {
		if (isNodeAnOperator(node) && !isNodeAPriority(node))
			cache = node;
	}

	static boolean isNodeAPriority(Nodeable node) {
		return ((Node) node).getPriorityIndex() <= ((Node) Node.mainQueue).getPriorityIndex();
	}

	static boolean isNodeAnOperator(Nodeable node) {
		return ((Node) node).getPriorityIndex() < Priority.VALUE.ordinal() >> 1;
	}

	static boolean isQueueEmpty() {
		boolean
				condition1 = Node.mainQueue.getLeft() == Node.empty,
				condition2 = isNodeTheLastInQueue(Node.empty),
				condition3 = Node.mainQueue == null;

		return (condition1 && condition2) || condition3;
	}

	static boolean isQueueASingleItem() {
		boolean
				condition1 = isNodeTheLastInQueue(Node.mainQueue.getLeft()),
				condition2 = Node.mainQueue.getLeft() != Node.empty;
		return condition1 && condition2;
	}

	static boolean isNodeTheLastInQueue(Nodeable node) {
		return node == Node.mainQueue.getRite();
	}


//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\



	/*static Nodeable updateCache() {
		return cache;
	}*/


}