import org.junit.*;

public class NodeableTest {

	@Before
	public void initial() {
		Node.mainQueue = new Node(Node.empty);
		Assert.assertNull(Node.mainQueue.getLeft());
		Assert.assertNull(Node.mainQueue.getRite());
		Assert.assertNull(Node.mainQueue.getRoot());
	}

//	updateQueue	//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Test
	public void void_updateQueue_01() {
		Node
				nod1 = new Node(Node.empty);
		nod1.priorityType = Priority.VALUE;
		nod1.value = 0.;
		Node.mainQueue.addToQueue(nod1);

		Assert.assertSame(nod1, Node.mainQueue.getLeft());
		Assert.assertSame(nod1, Node.mainQueue.getRite());
	}

	@Test
	public void void_updateQueue_02() {
		Node
				nod1 = new Node(Node.empty),
				nod2 = new Node(Node.empty);
		nod1.priorityType = Priority.VALUE;
		nod2.priorityType = Priority.ADD;
		Node.mainQueue.addToQueue(nod1);
		Node.mainQueue.addToQueue(nod2);

		Assert.assertSame(nod1, Node.mainQueue.getLeft());
		Assert.assertSame(nod2, Node.mainQueue.getRite());
	}

	@Test
	public void queueable_updateQueue_01() {
		Node
				nod1 = new Node(Node.empty);
		nod1.priorityType = Priority.VALUE;
		Node.mainQueue.addToQueue(nod1);

		Assert.assertSame(nod1, Node.mainQueue.takeFromQueue());
		Assert.assertNull(Node.mainQueue.getLeft());
		Assert.assertNull(Node.mainQueue.getRite());
	}

	@Test
	public void queueable_updateQueue_02() {
		Node
				nod1 = new Node(Node.empty),
				nod2 = new Node(Node.empty);
		nod1.priorityType = Priority.VALUE;
		nod2.priorityType = Priority.ADD;
		Node.mainQueue.addToQueue(nod1);
		Node.mainQueue.addToQueue(nod2);

		Assert.assertSame(nod1, Node.mainQueue.takeFromQueue());
		Assert.assertSame(nod2, Node.mainQueue.getLeft());
		Assert.assertSame(nod2, Node.mainQueue.getRite());
	}

//	branches  \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Test
	public void getLeft_01() {
		Nodeable
				nod1 = new Node(Node.empty);

		((Node) nod1).priorityType = Priority.VALUE;

		Node.mainQueue.addToQueue(nod1);

		Assert.assertSame(nod1, Node.mainQueue.getLeft());
	}

	@Test
	public void getRite_01() {
		Nodeable
				nod1 = new Node(Node.empty);

		((Node) nod1).priorityType = Priority.VALUE;

		Node.mainQueue.addToQueue(nod1);

		Assert.assertSame(nod1, Node.mainQueue.getRite());
	}
}