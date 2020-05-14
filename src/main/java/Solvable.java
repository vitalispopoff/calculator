public interface Solvable extends Queueable {

//	@formatter:off

	default void solve () { convertToLocalTree ( getHead ()); }

	default Queueable convertToLocalTree (Queueable queueable) {
		if ( isSingle ())
			return ( getHead ());
		else {
			if (search (queueable))
				collapseToLocalTree (queueable);
			else
				return convertToLocalTree (getTail ());
		}
		return null;
	}

	default boolean search (Queueable queueable) { return false; }

	default void collapseToLocalTree (Queueable queueable) { }

//	@formatter:on

}