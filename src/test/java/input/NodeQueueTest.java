package input;

import calculation.*;
import calculation.calculations.*;
import org.junit.*;

public class NodeQueueTest {
    static Typical
            typ1 = NodeType.VALUE,
            typ2 = NodeType.EXPONENT,
            typ3 = NodeType.VALUE,
            typ4 = NodeType.ADD,
            typ5 = NodeType.VALUE;
    static int
            ord1, ord2, ord3, ord4, ord5;
    static Nodeable
            nod1, nod2, nod3, nod4, nod5;
    static Enqueued
            que1, que2, que3, que4, que5;
    static Queuing
            Q1;

    @Before
    public void initial() {
        ord1 = typ1.getTypePriority();
        nod1 = typ1.interact();
        nod2 = typ2.interact();
        nod3 = typ3.interact();
        que1 = new Queuer(nod1);
        que2 = new Queuer(nod2);
        que3 = new Queuer(nod3);

        Q1 = new NodeQueue(null);
        Q1.updateQueue(que1);
    }

    @After
    public void terminal() {
        nod1 = nod2 = nod3 = null;
        que1 = que2 = que3 = null;
        Q1 = null;
    }

    @Test
    public void initial_test() {
        Assert.assertEquals(4, ord1);
        Assert.assertTrue(nod1 instanceof Value);
        Assert.assertTrue(nod2 instanceof Calculation_Exponentiation);
        Assert.assertTrue(nod3 instanceof Value);
        Assert.assertSame(que1, Q1.getHead());
        Assert.assertSame(que1, Q1.getTail());
    }

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

// !SSUE#12
    @Test
    public void currentPriorityIndex_00() {
        Assert.assertEquals(ord1, Q1.currentPriorityIndex());
    }
}