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

		n1.setNumberValue(0.5);
		n3.setNumberValue(1.);
		n5.setNumberValue(2.);

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

	//	@Ignore
	@Test
	public void convertToTree_01() {
		initial_01();
		((Node) Node.mainQueue).convertToTree();
		Assert.assertSame(n2, Node.mainQueue.getHead());
	}

//	@Ignore
	@Test
	public void convertToTree_02() {
		initial_02();
		((Node)Node.mainQueue).convertToTree();
		Assert.assertEquals(1., Node.mainQueue.getHead().getNumberValue(), 0.);


	}

	//	@formatter:on

}