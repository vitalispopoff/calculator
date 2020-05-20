package data;

import logic.Type;
import org.junit.*;

public class NodeTest {

//	@formatter:of

	static Queueable n1, n2, n3, n4, n5;

	@Before public void initial(){
		Node.mainQueue.setHead(null);
		Node.mainQueue.setTail(null);

		n1 = new Node();
		n2 = new Node();
		n3 = new Node();
		n4 = new Node();
		n5 = new Node();

		n1.setType(Type.VALUE);
		n3.setType(Type.VALUE);
		n5.setType(Type.VALUE);

		n2.setType(Type.ADD);
		n4.setType(Type.DIVIDE);
	}
	private void initial_01(){
		Node.mainQueue.add(n1);
		Node.mainQueue.add(n2);
		Node.mainQueue.add(n3);
	}
	private void initial_02(){
		initial_01();
		Node.mainQueue.add(n4);
		Node.mainQueue.add(n5);
	}

	@Test public void convertToLocalTree_01(){
		initial_01();
//		(Treeable)Node.mainQueue.getHead()).convertToLocalTree());

		Queueable expect = ((Treeable)Node.mainQueue).convertToLocalTree(Node.mainQueue.getHead());


		Assert.assertSame(n2, expect);
	}
	@Test public void convertToLocalTree_02(){
		initial_01();
		Queueable expect = ((Treeable)Node.mainQueue).convertToLocalTree(Node.mainQueue.getHead());
		Assert.assertSame(n1, expect.getHead());
	}
	@Test public void convertToLocalTree_03(){
		initial_01();
		Queueable expect = ((Treeable)Node.mainQueue).convertToLocalTree(Node.mainQueue.getHead());
		Assert.assertSame(n3, expect.getTail());
	}
	@Test public void convertToLocalTree_04(){
		initial_01();
		Queueable expect = ((Treeable)Node.mainQueue).convertToLocalTree(Node.mainQueue.getHead());
		Assert.assertSame(n2, expect.getHead().getNext());
	}
	@Test public void convertToLocalTree_05(){
		initial_01();
		Queueable expect = ((Treeable)Node.mainQueue).convertToLocalTree(Node.mainQueue.getHead());
		Assert.assertSame(n2, expect.getTail().getPrev());
	}
	@Test public void convertToLocalTree_06(){
		initial_02();
		((Treeable)Node.mainQueue).convertToLocalTree(n3);
		Queueable expect = ((Treeable)Node.mainQueue).convertToLocalTree(Node.mainQueue.getHead());
		Assert.assertSame(n3, expect.getTail().getHead());
	}

//	@formatter:on

}
