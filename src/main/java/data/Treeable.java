//	@formatter:off

package data;

public interface Treeable extends Queueable {

	void convertToTree();

	void setLeft(Queueable q);
	Queueable getLeft();

	void setRite(Queueable q);
	Queueable getRite();

//	--------------------------------------------------------------------------------------------------------------------

	default Queueable convertToLocalTree(Queueable cache) {

		Queueable
			Q0 = cache.getPrev() == getHead()
				? null
				: cache.getPrev(),
			Q1 = cache,
			Q2 = cache.getNext(),
			Q3 = Q2.getNext(),

			QN = Q3.getNext() == getTail()
				? null
				: Q3.getNext();

		if (Q0 != null)
			Q0.setNext(Q2);
		else
			setHead(Q2);

		if (QN != null)
			QN.setPrev(Q2);
		else
			setTail(Q2);

		Q2.setTail(Q3);
		Q2.setNext(QN);

		if (QN != null)
			Q3.setNext(null);

		if (Q0 != null)
			Q1.setPrev(null);

		Q2.setPrev(Q0);
		Q2.setHead(Q1);

		return Q2;
	}

	default Queueable priorityCheck(Queueable q) {

		Queueable
			Q1 = q == getTail()
				? getHead()
				: q,
			Q2 = Q1.getNext(),
			Q3 = Q2.getNext();

		if (!Double.isNaN(Q1.getNumberValue()) && !Double.isNaN(Q3.getNumberValue())) {

			int
				Q2Priority = Q2.getType().ordinal() >> 1;

			if (Q2Priority > 0 && Q2Priority <= Node.mainQueue.getCurrentType())
				return Q1;

			else
				return Q3;
		}

		else
			return null;
	}
}

//	@formatter:on