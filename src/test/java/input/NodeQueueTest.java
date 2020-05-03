package input;

import calculation.*;
import calculation.calculations.*;
import org.junit.*;

import static memory.Memory.mainQueue;

public class NodeQueueTest {
    static Typical
            typVal = NodeType.VALUE,
            typ2 = NodeType.EXPONENT;
    static int
            ord1;
    static Nodeable
            nod1, nod2, nod3;
    static Enqueued
            que1, que2, que3;

    @Before
    public void initial() {
        ord1 = typVal.getTypePriority();
        nod1 = typVal.interact();
        nod2 = typ2.interact();
        nod3 = typVal.interact();
        que1 = new Queuer(nod1);
        que2 = new Queuer(nod2);
        que3 = new Queuer(nod3);

        mainQueue = new NodeQueue(null);
        mainQueue.updateQueue(que1);
    }

    @After
    public void terminal() {
        nod1 = nod2 = nod3 = null;
        que1 = que2 = que3 = null;
    }

    @Test
    public void initial_test() {
        Assert.assertEquals(4, ord1);
        Assert.assertTrue(nod1 instanceof Value);
        Assert.assertTrue(nod2 instanceof Calculation_Exponentiation);
        Assert.assertTrue(nod3 instanceof Value);
        Assert.assertSame(que1, mainQueue.getHead());
        Assert.assertSame(que1, mainQueue.getTail());
    }

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Test
    public void currentPriorityIndex_00() {
        Assert.assertEquals(ord1, mainQueue.currentPriorityIndex());
    }
}