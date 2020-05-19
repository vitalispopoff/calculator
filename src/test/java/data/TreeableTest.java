package data;

import logic.Type;
import org.junit.*;

import static data.Queueable.mainQueueable;

public class TreeableTest {

	static Treeable n1, n2, n3, n4, n5;

	@Before
	public void initial() {
		mainQueueable.setHead(null);
		mainQueueable.setTail(null);
		n1 = new Node();
		n2 = new Node();
		n3 = new Node();
		n4 = new Node();
		n5 = new Node();
		((Node) n1).setType(Type.VALUE);
		((Node) n3).setType(Type.VALUE);
		((Node) n5).setType(Type.VALUE);

		((Node) n2).setType(Type.ADD);
		((Node) n4).setType(Type.DIVIDE);

		((Node) n1).setValue(1.);
		((Node) n3).setValue(1.);
		((Node) n5).setValue(2.);
	}

	@Ignore
	@Test
	public void Treeable_01() {
		mainQueueable.add(n1);
		mainQueueable.add(n2);
		mainQueueable.add(n3);

		Assert.assertSame(n1, n2.getLeft());
		Assert.assertSame(n3, n2.getRite());

	}
}
