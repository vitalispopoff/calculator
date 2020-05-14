import org.junit.*;

public class SolverTest {

	static Nodeable n1, n2, n3, n4, n5;

	@Before
	public void initial() {
		Solver.cache = Node.empty;
		n1 = new Node(Priority.VALUE);
		n2 = new Node(Priority.SUBTRACT);
		n3 = new Node(Priority.VALUE);
		n4 = new Node(Priority.MULTIPLY);
		n5 = new Node(Priority.VALUE);

		Node.mainQueue.addToQueue(n1);
		Node.mainQueue.addToQueue(n2);
		Node.mainQueue.addToQueue(n3);
		Node.mainQueue.addToQueue(n4);
		Node.mainQueue.addToQueue(n5);
	}

	@Test
	public void iQueueASingleItem_01(){
		Node.mainQueue = new Node(Node.empty);
		Assert.assertFalse(Solver.isQueueASingleItem());

		Node.mainQueue.addToQueue(n1);
		Assert.assertTrue(Solver.isQueueASingleItem());

		Node.mainQueue.addToQueue(n2);
		Assert.assertFalse(Solver.isQueueASingleItem());
	}

	@Test
	public void isNodeAPriority_01() {
		Assert.assertTrue(Solver.isNodeAPriority(n4));
		Assert.assertFalse(Solver.isNodeAPriority(n1));
	}

	@Test
	public void isNodeAnOperator_01(){
		Assert.assertFalse(Solver.isNodeAnOperator(n1));
		Assert.assertTrue(Solver.isNodeAnOperator(n4));
	}

	@Test
	public void updateCache_01(){
		Assert.assertSame(Node.empty, Solver.cache);
		Solver.updateCache(n2);
		Assert.assertSame(n2, Solver.cache);
	}

	@Test
	public void updateCache_02(){
		Solver.updateCache(n2);
		Solver.updateCache(n3);
		Assert.assertSame(n2, Solver.cache);
		Solver.updateCache(n4);
		Assert.assertSame(n2, Solver.cache);
	}

	@Test
	public void constructLocalTree_01(){
		Solver.updateCache(n2);
		Nodeable result = Solver.constructLocalTree(n4);
		Assert.assertSame(n3, result.getLeft());
		Assert.assertSame(n4, result);
		Assert.assertSame(n4, n2.getRoot());
		Assert.assertSame(n4, n3.getRoot());
		Assert.assertSame(n4, n5.getRoot());
		Assert.assertSame(n5, result.getRite());
		Assert.assertNull(n4.getRoot());
	}

	@Ignore
	@Test
	public void convertToLocalTree_01(){

		Assert.assertNotNull(Node.mainQueue.getLeft());
		Assert.assertSame(n1, Node.mainQueue.getLeft());



//		Solver.convertToLocalTree(Node.mainQueue.getLeft());

	}

}