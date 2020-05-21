package data;

public interface Treeable extends Queueable {


	void setLeft(Queueable q);

	void setRite(Queueable q);

	Queueable getLeft();

	Queueable getRite();

	void convertToTree();

	default public Queueable convertToLocalTree(Queueable q) {

		Queueable
				localLeft = q,
				localRoot = q.getNext(),
				localRite = q.getNext().getNext();

		if (localLeft.getPrev() != null)
			localLeft.getPrev().setNext(localRoot);
		else setHead(localRoot);

		if (localRite.getNext() != null)
			localRite.getNext().setPrev(localRoot);
		else setTail(localRoot);

		localRoot.setTail(localRite);
		localRoot.setNext(localRite.getNext());

		localRite.setNext(null);
		localLeft.setPrev(null);

		localRoot.setPrev(localLeft.getPrev());
		localRoot.setHead(localLeft);

		return localRoot;
	}

	default public Queueable priorityCheck(Queueable q) {

		if (q == getTail()) return q.getHead();

		Queueable
				localLeft = q,
				localRite = q.getNext().getNext();

		if (!Double.isNaN(localLeft.getValue())) {
			Queueable localRoot = localLeft.getNext();
			int localRootPriority = localRoot.getType().ordinal() >> 1;

			if (localRootPriority > 0 && localRootPriority <= Node.mainQueue.getCurrentType())
				return localLeft;
		}
		return localRite;
	}
}