package logic;

public interface Solvable /*extends Queueable*/ {

//	@formatter:off

	/*default*/ void solve () /*{ convertToLocalTree ( getHead ()); }*/;

	Solvable/*default Queueable*/ convertToLocalTree /*(Queueable queueable) {
		if ( isSingle ())
			return ( getHead ());
		else {
			if (search (queueable))
				collapseToLocalTree (queueable);
			else
				return convertToLocalTree (getTail ());
		}
		return null;
	}*/(Solvable solvable);

	/*default*/ boolean search/* (Queueable queueable) { return false; }*/(Solvable solvable);

	/*default*/ void collapseToLocalTree /*(Queueable queueable) { }*/(Solvable solvable);

//	@formatter:on

}