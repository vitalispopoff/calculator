package input;

import org.junit.*;

import calculation.*;

public class NodeQueueTest {

    static Typical
            typ1,
            typ2;
    static Nodeable
            nod1,
            nod2;
    static Queueable
            que1,
            que2,
            Q1;
    static int
            ord1,
            ord2;

    @Before
    public void setup_01() {
        typ1 = NodeType.VALUE;
        ord1 = typ1.ordinal();
        nod1 = typ1.interact();
        que1 = new Queuer(nod1);
        Q1 = new NodeQueue(que1);
        Assert.assertEquals(ord1, nod1.getType().ordinal());
    }

    private void setup_02() {
        typ2 = NodeType.EXPONENT;
        ord2 = typ2.ordinal();
        nod2 = typ2.interact();
        que2 = new Queuer(nod2);
        Q1.addToQueue(que2);
        Assert.assertEquals(ord2, nod2.getType().ordinal());
    }

    @Test
    public void CalculationQueue_01() {
        Assert.assertEquals(1, ((NodeQueue) Q1).length);
    }

    @Test
    public void CalculationQueue_02() {
        Assert.assertNotNull(((NodeQueue) Q1).priorityTypes);
    }

    @Test
    public void addToPriorityTypes_01() {
        Assert.assertEquals(1, ((NodeQueue) Q1).priorityTypes[ord1]);
    }

    @Test
    public void removeFromPriorityTypes_01() {
        Q1.removeFromPriorityTypes();
        Assert.assertEquals(0, ((NodeQueue) Q1).priorityTypes[ord1]);
    }

    @Test
    public void addToQueue_01() {
        setup_02();
        Assert.assertSame(que2, Q1.getPostOne());
    }

    @Test
    public void addToQueue_02() {
        setup_02();
        Assert.assertSame(que1, que2.getPrevOne());
    }

    @Test
    public void addToQueue_03() {
        setup_02();
        Assert.assertSame(1, ((NodeQueue) Q1).priorityTypes[ord2]);
    }

    @Test
    public void removeFromQueue_01() {
        setup_02();
        Assert.assertSame(que1, Q1.removeFromQueue());
    }

    @Test
    public void removeFromQueue_02() {
        setup_02();
        Q1.removeFromQueue();
        Assert.assertNull(que2.getPrevOne());
    }

    @Test
    public void removeFromQueue_03() {
        setup_02();
        Q1.removeFromQueue();
        Assert.assertNull(que1.getPostOne());
    }

    @Test
    public void removeFromQueue_04() {
        setup_02();
        Q1.removeFromQueue();
        Assert.assertEquals(0, ((NodeQueue) Q1).priorityTypes[ord1]);
    }

    @Test
    public void removeFromQueue_05() {
        setup_02();
        Q1.removeFromQueue();
        Assert.assertEquals(1, ((NodeQueue) Q1).priorityTypes[ord2]);
    }
}