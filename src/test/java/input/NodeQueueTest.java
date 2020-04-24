package input;

import org.junit.*;

import calculation.*;

public class NodeQueueTest {

    static Typical
            typ1,
            typ2,
            typ3;
    static Nodeable
            nod1,
            nod2,
            nod3;
    static Queueable
            que1,
            que2,
            que3,
            Q1;
    static int
            ord1,
            ord2,
            ord3;

    static {
        typ1 = NodeType.VALUE;
    }

    private void setup_01() {
        typ2 = NodeType.EXPONENT;
        ord2 = typ2.ordinal();
        nod2 = typ2.interact();
        que2 = new Queuer(nod2);
        Q1.addToQueue(que2);
        Assert.assertEquals(ord2, nod2.getType().ordinal());
    }

    private void setup_02() {
        typ3 = typ1;
        ord3 = typ3.ordinal();
        nod3 = typ3.interact();
        que3 = new Queuer(nod3);
        Q1.addToQueue(que3);
        Assert.assertEquals(ord3, nod3.getType().ordinal());
    }

    @Before
    public void setup() {
        ord1 = typ1.ordinal();
        nod1 = typ1.interact();
        que1 = new Queuer(nod1);
        Q1 = new NodeQueue(que1);
        Assert.assertEquals(ord1, nod1.getType().ordinal());
    }


    void convertToLocalTree_initial() {
        setup_01();
        setup_02();
        Assert.assertSame(que1, Q1.getHead());
        Assert.assertSame(que3, Q1.getTail());
        Assert.assertSame(que2, que1.getTail());
        Assert.assertSame(que3, que2.getTail());
        Assert.assertEquals(2, ((NodeQueue) Q1).priorityTypes[ord1]);
        Assert.assertEquals(1, ((NodeQueue) Q1).priorityTypes[ord2]);
        Assert.assertEquals(3, ((NodeQueue) Q1).length);
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
        setup_01();
        Assert.assertSame(que2, Q1.getTail());
    }

    @Test
    public void addToQueue_02() {
        setup_01();
        Assert.assertSame(que1, que2.getHead());
    }

    @Test
    public void addToQueue_03() {
        setup_01();
        Assert.assertSame(1, ((NodeQueue) Q1).priorityTypes[ord2]);
    }

    @Test
    public void removeFromQueue_01() {
        setup_01();
        Assert.assertSame(que1, Q1.removeFromQueue());
    }

    @Test
    public void removeFromQueue_02(){


    }

    @Test
    public void removeFromQueue_03() {
        setup_01();
        Q1.removeFromQueue();
        Assert.assertNull(que2.getHead());
    }

    @Test
    public void removeFromQueue_04() {
        setup_01();
        Q1.removeFromQueue();
        Assert.assertNull(que1.getTail());
    }

    @Test
    public void removeFromQueue_05() {
        setup_01();
        Q1.removeFromQueue();
        Assert.assertEquals(0, ((NodeQueue) Q1).priorityTypes[ord1]);
    }

    @Test
    public void removeFromQueue_06() {
        setup_01();
        Q1.removeFromQueue();
        Assert.assertEquals(1, ((NodeQueue) Q1).priorityTypes[ord2]);
    }

    @Test
    public void isPrevOneValue_01(){
        Assert.assertTrue(Q1.isPrevOneValue());
    }
    @Test
    public void isPrevOneValue_02(){
        Assert.assertSame(que1, Q1.getHead());
        setup_01();
        Assert.assertSame(que1, Q1.getHead());
        Assert.assertSame(que2, Q1.getTail());
        Assert.assertSame(que1,Q1.removeFromQueue());
//        Assert.assertNull(Q1.getPrevOne());
        Assert.assertSame(que2, ((NodeQueue)Q1).head);
    }
}