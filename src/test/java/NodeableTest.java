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
        nod1.priorityType = Priority.VALUE;
        nod1.value = 0.;
        Node.mainQueue.addToQueue(nod1);

        Assert.assertSame(nod1, Node.mainQueue.getLeft());
        Assert.assertSame(nod1, Node.mainQueue.getRite());
    }

    @Test
    public void void_updateQueue_02(){
        Node
                nod1 = new Node(null),
                nod2 = new Node(null);
        nod1.priorityType = Priority.VALUE;
        nod2.priorityType = Priority.ADD;
        Node.mainQueue.addToQueue(nod1);
        Node.mainQueue.addToQueue(nod2);

        Assert.assertSame(nod1, Node.mainQueue.getLeft());
        Assert.assertSame(nod2, Node.mainQueue.getRite());
    }

    @Test
    public void queueable_updateQueue_01(){
        Node
                nod1 = new Node(null);
        nod1.priorityType = Priority.VALUE;
        Node.mainQueue.addToQueue(nod1);

        Assert.assertSame(nod1, Node.mainQueue.takeFromQueue());
        Assert.assertNull(Node.mainQueue.getLeft());
        Assert.assertNull(Node.mainQueue.getRite());
    }

    @Test
    public void queueable_updateQueue_02(){
        Node
                nod1 = new Node(null),
                nod2 = new Node(null);
        nod1.priorityType = Priority.VALUE;
        nod2.priorityType = Priority.ADD;
        Node.mainQueue.addToQueue(nod1);
        Node.mainQueue.addToQueue(nod2);

        Assert.assertSame(nod1, Node.mainQueue.takeFromQueue());
        Assert.assertSame(nod2, Node.mainQueue.getLeft());
        Assert.assertSame(nod2, Node.mainQueue.getRite());
    }
}