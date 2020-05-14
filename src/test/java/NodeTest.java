import org.junit.Assert;
import org.junit.Test;

public class NodeTest {

	@Test
	public void addToPriorityIndex_01() {
		int
				prioritiesAmount = Priority.values().length,
				expectation1 = 0,
				expectation2 = 0;

		Node.mainQueue = new Node(Node.empty);
		Assert.assertEquals(prioritiesAmount, ((Node) Node.mainQueue).priorityIndex.length);

		for (int i : ((Node) Node.mainQueue).priorityIndex) if (i == 0) expectation1++;
		Assert.assertEquals(prioritiesAmount, expectation1);

		((Node) Node.mainQueue).addToPriorityIndex(new Node(Priority.VALUE));
		Assert.assertEquals(1, ((Node) Node.mainQueue).priorityIndex[3]);

		for (int i : ((Node) Node.mainQueue).priorityIndex) expectation2 += i;
		Assert.assertEquals(1, expectation2);
	}

	@Test
	public void addToPriorityIndex_02() {
		int
				expectation = 0;
		Node
				n1 = new Node(Priority.VALUE);

		Node.mainQueue = new Node(n1);
		Assert.assertEquals(1, ((Node) Node.mainQueue).priorityIndex[3]);

	}

	@Test
	public void takeFromPriorityIndex_01(){
		Node
				n1 = new Node(Priority.VALUE);

		Node.mainQueue = new Node(n1);
		Assert.assertEquals(1, ((Node) Node.mainQueue).priorityIndex[3]);

		((Node)Node.mainQueue).takeFromPriorityIndex(n1);
		Assert.assertEquals(0, ((Node) Node.mainQueue).priorityIndex[3]);
	}

	@Test
	public void takeFromPriorityIndex_02(){
		Node.mainQueue = new Node(Node.empty);

		((Node)Node.mainQueue).takeFromPriorityIndex(new Node(Priority.VALUE));

		Assert.assertEquals(0, ((Node)Node.mainQueue).priorityIndex[3]);
	}

	@Test
	public void takeFromQueue_01(){
		Nodeable
				n1 = new Node(Priority.VALUE);

		Node.mainQueue = new Node(n1);

		Assert.assertSame(n1, Node.mainQueue.getLeft());

//		Assert.assertSame(n1, Node.mainQueue.takeFromQueue());


	}

}