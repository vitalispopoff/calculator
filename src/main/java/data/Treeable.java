package data;

public interface Treeable{

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

	 default void convertToTree(){}


}