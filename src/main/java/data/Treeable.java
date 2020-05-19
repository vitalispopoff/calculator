package data;

public interface Treeable /*extends Enqueued*/ {

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