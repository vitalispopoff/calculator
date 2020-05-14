public interface Nodeable extends Enqueued{

	void setLeft(Nodeable node);

	void setRite(Nodeable node);

	void setRoot(Nodeable node);

	Nodeable getLeft();

	Nodeable getRite();

	Nodeable getRoot();

//	@Overrides  //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override
	default void setPrev(Enqueued queuer){
		Nodeable node = (Nodeable)queuer;
		setLeft(node);
		setRite(node);
	}

	@Override
	default void setPost(Enqueued queuer){setRoot((Nodeable)queuer);}

	@Override
	default Enqueued getPrev(){
		return getLeft()==getRite()?(Enqueued) getLeft() : null;
	}

	@Override
	default Enqueued getPost(){return (Enqueued)getRoot();}
}