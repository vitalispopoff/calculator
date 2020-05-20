package data;

public interface Treeable extends Queueable{



	void setLeft(Queueable q);
	void setRite(Queueable q);

	Queueable getLeft();
	Queueable getRite();

	void convertToTree();

	/*Queueable convertToLocalTree();*/ // ? disposable ?

	default public Queueable convertToLocalTree(Queueable q) {

		Queueable
				localLeft = q,
				localRoot = q.getNext(),
				localRite = q.getNext().getNext();

		if (localLeft.getPrev() != null)
			localLeft.getPrev().setNext(localRoot);

		if (localRite.getNext() != null)
			localRite.getNext().setPrev(localRoot);

		localRoot.setTail(localRite);
		localRoot.setNext(localRite.getNext());

		localRite.setNext(null);
		localLeft.setPrev(null);

		localRoot.setPrev(localLeft.getPrev());
		localRoot.setHead(localLeft);

		return localRoot;
	}

/*
	static final Queueable
			mainQueueable = Queueable.mainQueueable;

//	@formatter:off

	void setLeft (Queueable queueable);
	void setRite (Queueable queueable);
	void setRoot (Queueable queueable);

	Queueable getLeft ();
	Queueable getRite ();
	Queueable getRoot ();

	Queueable convertToLocalTree();

//	@formatter:on

	static void convertToTree() {

		Queueable
				localHead = mainQueueable.getHead(),
				localCache = null;

		for (; mainQueueable.isSingle(); ) {
			if (localHead.getTypeIndex() > mainQueueable.getTypeIndex()) {
				localCache = localHead;
				localHead = localHead.getTail();
			}
			else {
				localHead = ((Treeable) localHead).convertToLocalTree();
				((Nodeable) localCache).setRoot(localHead);
			}
		}

	}*/

}