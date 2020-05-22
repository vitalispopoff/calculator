package data;

import logic.Type;
import org.junit.*;

public class NodeTest {

//	@formatter:of

	static Queueable n1, n2, n3, n4, n5, result;

	@Before
	public void initial() {
		result = null;

		Node.mainQueue.setHead(null);
		Node.mainQueue.setTail(null);
		((Node) Node.mainQueue).typeIndex = new int[Type.values().length >> 1];

		n1 = new Node();
		n2 = new Node();
		n3 = new Node();
		n4 = new Node();
		n5 = new Node();

		n1.setType(Type.VALUE);
		n3.setType(Type.VALUE);
		n5.setType(Type.VALUE);

		n1.setValue(0.5);
		n3.setValue(1.);
		n5.setValue(2.);

		n2.setType(Type.ADD);
		n4.setType(Type.DIVIDE);

		Node.mainQueue.add(n1);
		Node.mainQueue.add(n2);
		Node.mainQueue.add(n3);
		Node.mainQueue.add(n4);
		Node.mainQueue.add(n5);
	}

	//	@Ignore
	@Test
	public void convertToTree_01() {
		((Node) Node.mainQueue).convertToTree();
		Assert.assertSame(n2, Node.mainQueue.getHead());
	}

//	@formatter:on

	@Test
	public void convertToTree_02() {
		((Node)Node.mainQueue).convertToTree();
		Assert.assertEquals(1., Node.mainQueue.getHead().getValue(), 0.);


	}


}