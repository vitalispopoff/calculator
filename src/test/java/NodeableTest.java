import org.junit.*;

public class NodeableTest {

    @Before
    public void initial(){
        Node.mainQueue = new Node(null);
        Assert.assertNull(Node.mainQueue.getLeft());
        Assert.assertNull(Node.mainQueue.getRite());
        Assert.assertNull(Node.mainQueue.getRoot());
    }

//\\ updateQueue  \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Test
    public void void_updateQueue_01(){
        Node
                nod1 = new Node(null);
/*        nod1.priorityType = Priority.VALUE;
        nod1.value = 0.;*/
        Node.mainQueue.updateQueue(nod1);

        Assert.assertSame(nod1, Node.mainQueue.getLeft());
        Assert.assertSame(nod1, Node.mainQueue.getRite());
    }

    @Test
    public void void_updateQueue_02(){
        Node
                nod1 = new Node(null),
                nod2 = new Node(null);
        Node.mainQueue.updateQueue(nod1);
        Node.mainQueue.updateQueue(nod2);

        Assert.assertSame(nod1, Node.mainQueue.getLeft());
        Assert.assertSame(nod2, Node.mainQueue.getRite());
    }

    @Test
    public void queueable_updateQueue_01(){
        Node
                nod1 = new Node(null);
        Node.mainQueue.updateQueue(nod1);
        Assert.assertSame(nod1, Node.mainQueue.updateQueue());
        Assert.assertNull(Node.mainQueue.getLeft());
        Assert.assertNull(Node.mainQueue.getRite());
    }

    @Test
    public void queueable_updateQueue_02(){
        Node
                nod1 = new Node(null),
                nod2 = new Node(null);
        Node.mainQueue.updateQueue(nod1);
        Node.mainQueue.updateQueue(nod2);

        Assert.assertSame(nod1, Node.mainQueue.updateQueue());
        Assert.assertSame(nod2, Node.mainQueue.getLeft());
        Assert.assertSame(nod2, Node.mainQueue.getRite());
    }

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Ignore
    @Test
    public void updatePriorityIndex_01(){
        Node
                nod1 = new Node(null);
        nod1.priorityType = Priority.EXPONENT;
        int expectation = Priority.EXPONENT.ordinal()>>1;

        Node.mainQueue.updateQueue();
    }
}