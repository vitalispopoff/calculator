package input;

import calculation.*;
import calculation.calculations.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NodeQueueTest {
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
    ord4 ,
    ord5;
    static Nodeable
            node1 = typ1.interact(),
            node2 = typ2.interact(),
            node3 = typ3.interact(),
    node4,
    node5;
    static Enqueued
            que1 = new Queuer(node1),
            que2 = new Queuer(node2),
            que3 = new Queuer(node3),
    que4,
    que5;
    static Queuing
    Q1 = new NodeQueue(que1);

    @Before
    public void setup_0() {
        Q1.updateQueue(que1);
    }

    @Test
    public void initial_test() {
        Assert.assertTrue(node1 instanceof Value);
        Assert.assertTrue(node2 instanceof Calculation_Exponentiation);
        Assert.assertTrue(node3 instanceof Value);
        Assert.assertSame(que1, Q1.getHead());
        Assert.assertSame(que1, Q1.getTail());
    }

}