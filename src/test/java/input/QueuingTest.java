package input;

import calculation.*;
import org.junit.*;

public class QueuingTest {

    static Typical
            typ1 = NodeType.VALUE,
            typ2 = NodeType.EXPONENT,
            typ3 = NodeType.VALUE,
            typ4 = NodeType.ADD,
            typ5 = NodeType.VALUE;
    static int
            ord1 = typ1.ordinal(),
            ord2 = typ2.ordinal(),
            ord3 = typ3.ordinal(),
            ord4 = typ4.ordinal(),
            ord5 = typ5.ordinal();
    static Nodeable
            node1 = typ1.interact(),
            node2 = typ2.interact(),
            node3 = typ3.interact(),
            node4 = typ4.interact(),
            node5 = typ5.interact();
    static Enqueued
            que1 = new Queuer(node1),
            que2 = new Queuer(node2),
            que3 = new Queuer(node3),
            que4 = new Queuer(node4),
            que5 = new Queuer(node5);
    static Queuing
            Q1;

    @Before
    public void initial() {
        Q1 = new NodeQueue(que1);
    }

    private void setup_01() {
        Q1.updateQueue(que2);
        Q1.updateQueue();
    }

    @Test
    public void head_00() {
        Q1.setHead(que2);
        Assert.assertSame(que2, Q1.getHead());
    }

    @Test
    public void tail_00() {
        Q1.setTail(que2);
        Assert.assertSame(que2, Q1.getTail());
    }


    @Test       // method return
    public void updateQueue_sub00() {
        Assert.assertSame(que1, Q1.updateQueue());
    }

    @Test       // queue tail is empty
    public void updateQueue_sub01() {
        Q1.updateQueue();
        Assert.assertNull(Q1.getTail());
    }

    @Test       // queue head is moved (this case its null)
    public void updateQueue_sub02() {
        Q1.updateQueue();
        Assert.assertNull(Q1.getHead());
    }

    @Test
    public void updateQueue_sub03() {
        Q1.updateQueue();
        Assert.assertNull(que1.getTail());
    }

    @Test
    public void updateQueue_sub04(){

    }


    @Ignore
    @Test
    public void updatedQueue_add0y() {
        Q1.updateQueue(que2);
        Assert.assertSame(que2, Q1.getTail());
    }

    @Ignore
    @Test
    public void updateQueue_add0x() {
        Q1.updateQueue(que2);
        Assert.assertSame(que1, que2.getHead());
    }


    @Ignore
    @Test
    public void updateQueue_add02() {
        Q1.updateQueue(que2);
        Assert.assertSame(Q1.getTail().getHead().getTail(), que2);
    }

}