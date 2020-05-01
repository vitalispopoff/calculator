package input;

import _notes._QueuingTest_Notes;
import calculation.*;
import org.junit.*;

public class QueuingTest implements _QueuingTest_Notes {

    static Typical
            typ1 = NodeType.VALUE,
            typ2 = NodeType.EXPONENT,
            typ3 = NodeType.VALUE,
            typ4 = NodeType.ADD,
            typ5 = NodeType.VALUE,
            typ_ = NodeType.VALUE,
            typ0 = NodeType.SUBTRACT;

    static Nodeable
            nod1 = typ1.interact(),
            nod2 = typ2.interact(),
            nod3 = typ3.interact(),
            nod4 = typ4.interact(),
            nod5 = typ5.interact(),
            nod_ = typ_.interact(),
            nod0 = typ0.interact();
    static int
            ord1, ord2, ord3, ord4, ord5;
    static Enqueued
            que1, que2, que3, que4, que5, que_, que0;
    static Queuing
            Q0, Q1;

//\\ support methods /\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Before
    public void initial() {
        ord1 = typ1.getTypePriority();
        nod1.setValue(2.);
        nod3.setValue(0.);
        nod5.setValue(1.);
        que1 = new Queuer(nod1);
        que2 = new Queuer(nod2);
        que3 = new Queuer(nod3);
        que4 = new Queuer(nod4);
        que5 = new Queuer(nod5);
        Q1 = new NodeQueue(que1);
        Q0 = new NodeQueue(null);
    }

    @After
    public void terminal() {
        que1 = que2 = que3 = que4 = que5 = null;
        Q0 = Q1 = null;
    }

    private void initial_00() {
        ((NodeQueue) Q0).head = que1;
        ((NodeQueue) Q0).tail = que1;
    }

    private void initial_01(){

        nod_.setValue(2.);
        que_ = new Queuer(nod_);
        que0 = new Queuer(nod1);
        initial();
        Q0.updateQueue(que_);
        Q0.updateQueue(que0);
    }

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Override
    public void convertToLocalTree_initial() {
        Q0.updateQueue(que1);
        Q0.updateQueue(que2);
        Q0.updateQueue(que3);
        Q0.updateQueue(que4);
        Q0.updateQueue(que5);
    }

    @Test
    public void constructLocalSubTree_initial_00() {
        convertToLocalTree_initial();
        Assert.assertSame(que1, Q0.getHead());
        Assert.assertSame(que5, Q0.getTail());
        Assert.assertSame(que4, Q0.getTail().getHead());
        Assert.assertSame(que4, Q0.getHead().getTail().getTail().getTail());
        Assert.assertEquals(4, ord1);
    }

//    @Ignore
    @Test
    public void convertToLocalTree_01() {
        convertToLocalTree_initial();
        Q0.convertToLocalTree(Q0.updateQueue());
        Assert.assertSame(que4, Q0.getHead());
    }

//    @Ignore
    @Test
    public void convertToLocalTree_02() {
        convertToLocalTree_initial();
        Q0.convertToLocalTree(Q0.updateQueue());
        Assert.assertSame(nod2, ((Enqueued) Q0.getHead()).getNode().getLocalLeft());
        Assert.assertSame(nod1, nod2.getLocalLeft());
        Assert.assertSame(nod3, nod2.getLocalRite());
        Assert.assertSame(nod5, ((Enqueued) Q0.getHead()).getNode().getLocalRite());
    }

//    @Ignore
    @Test
    public void convertToLocalTree_03() {
        convertToLocalTree_initial();
        Q0.convertToLocalTree(Q0.updateQueue());
        Assert.assertEquals(NodeType.VALUE.getTypePriority(), Q0.getCounter());
    }

//    @Ignore
    @Test
    public void convertToLocalTree_04() {
        convertToLocalTree_initial();
        Q0.convertToLocalTree(Q0.updateQueue());
        Assert.assertSame(Q0.getHead(), Q0.getTail());
        Assert.assertNotNull(Q0.getHead());
    }

//    @Ignore
    @Test
    public void convertToLocalTree_05() {
        convertToLocalTree_initial();
        Q0.convertToLocalTree(Q0.updateQueue());
        Nodeable result = ((Enqueued) Q0.getHead()).getNode();
        Double value = result.getValue();
        Assert.assertEquals(2., value, 0.);
    }

//    @Ignore
    @Test
    public void convertToLocalTree_06(){
        initial_01();
        convertToLocalTree_initial();
        Assert.assertSame(que_, Q0.getHead());
        Assert.assertSame(que5, Q0.getTail());
        Q1.convertToLocalTree(Q1.updateQueue());
        Nodeable result = ((Enqueued) Q0.getHead()).getNode();
        Double value = result.getValue();
        Assert.assertEquals(2., value, 0.);
    }

//\\ updateQueue() \//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Override
    public void updateQueue_Ext_initial() {
        ((Queuer) que1).tail = que2;
        ((Queuer) que2).head = que1;
        ((NodeQueue) Q1).tail = que2;
    }

    @Test
    public void updateQueue_ext_00() {
        updateQueue_Ext_initial();
        Assert.assertSame(que1, Q1.getHead());
        Assert.assertSame(que2, Q1.getTail());
        Assert.assertSame(que2, que1.getTail());
        Assert.assertSame(que1, que2.getHead());
        Assert.assertNull(que1.getHead());
        Assert.assertNull(que2.getTail());
    }

    @Test
    public void updateQueue_ext_01() {
        updateQueue_Ext_initial();
        Assert.assertSame(que1, Q1.updateQueue());
    }

    @Test
    public void updateQueue_ext_02() {
        updateQueue_Ext_initial();
        Queueable
                expectation = Q1.getHead().getTail();
        System.out.println("   Q1 head is  que2 : " + (Q1.getHead().getTail() == que2));
        System.out.println("   method return's tail is que2 : " + (Q1.updateQueue().getTail() == que2));
        System.out.println("   after method Q1 head is que2 :" + (Q1.getHead() == que2));
        Assert.assertSame(que2, Q1.getHead());
        Queueable
                result = Q1.getHead();
        Assert.assertSame(expectation, result);

    }

    @Test
    public void updateQueue_ext_03() {
        updateQueue_Ext_initial();
        Q1.updateQueue();
        Assert.assertNull(Q1.getHead().getHead());
    }

    @Test
    public void updateQueue_ext_04() {
        updateQueue_Ext_initial();
        Assert.assertNull(Q1.updateQueue().getTail());
    }

    @Test
    public void updatedQueue_ext_06() {
        Q1.updateQueue();
        Assert.assertNull(Q1.getHead());
    }

    @Test
    public void updateQueue_ext_07() {
        Q1.updateQueue();
        Assert.assertNull(Q1.getTail());
    }

    @Test
    public void updatedQueue_ext08() {
        Q1.updateCounter();
        Assert.assertEquals(0, Q1.getCounter(Q1.getHead()));
    }

    @Test
    public void updateQueue_ext_09() {
        Q1.updateQueue();
        Assert.assertNull(Q1.updateQueue());
    }

//\\ updateQueue(Queueable) //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Override
    public void updateQueue_Add_initial() {
    }

    @Test
    public void updateQueue_Add_01() {
        System.out.println("   Is que1 a Q1's tail : " + (Q1.getTail() == que1));
        Queueable cache = Q1.getTail();
        Q1.updateQueue(que2);
        Assert.assertSame(cache, que2.getHead());
    }

    @Test
    public void updatedQueue_Add_02() {
        Queueable cache = Q1.getTail();
        Q1.updateQueue(que2);
        Assert.assertSame(que2, cache.getTail());
    }

    @Test
    public void updateQueue_Add_03() {
        Q1.updateQueue(que2);
        Assert.assertSame(que2, Q1.getTail());
    }

    @Test
    public void updateQueue_Add_05() {
        Q0.updateQueue(que2);
        Assert.assertNull(Q0.getHead().getTail());
    }

    @Test
    public void updateQueue_Add_06() {
        Q0.updateQueue(que2);
        Assert.assertNull(Q0.getTail().getHead());
    }

    @Test
    public void updateQueue_Add_07() {
        Q0.updateQueue(que2);
        Assert.assertSame(que2, Q0.getHead());
    }

    @Test
    public void updateQueue_Add_08() {
        Q0.updateQueue(que2);
        Assert.assertSame(que2, Q0.getTail());
    }

    @Test
    public void updatedQueue_Add_09() {
        Q0.updateQueue(que2);
        Assert.assertEquals(1, Q0.getCounter(Q0.getHead()));

    }

//\\ getCounter //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Override
    public void getCounter_initial(int ord, int val) {
        ((NodeQueue) Q1).nodeCounter[ord] = val;
    }

//    !SSUE#12
    @Test
    public void getCounter_01() {
        getCounter_initial(ord1, 1);
        Assert.assertEquals(1, Q1.getCounter(Q1.getHead()));
    }

    @Test
    public void getCounter_02() {
        Assert.assertEquals(0, Q0.getCounter(null));
    }

//\\ updateCounter(Typical) //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Override
    public void updateCounter_Add_initial() {
    }

    @Test
    public void updateCounter_Add_01() {
        initial_00();
        Q0.updateCounter(Q0.getHead());
        Assert.assertEquals(1, Q1.getCounter(Q0.getHead()));
    }

//\\ update Counter() \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Override
    public void updateCounter_Ext_initial() {
    }

//    !SSUE#12
    @Test
    public void updateCounter_Ext_01() {
        getCounter_initial(ord1, 1);
        Q1.updateCounter();
        Assert.assertEquals(0, Q1.getCounter(Q1.getHead()));
    }

    @Test
    public void updateCounter_Ext_02() {
        Q1.updateCounter();
        Assert.assertEquals(0, Q1.getCounter(Q1.getHead()));
    }

//\\ setHead(Queueable) //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Override
    public void setHead_initial() {
        Q1 = new NodeQueue(que1);
    }

    @Test
    public void setHead_00() {
        setHead_initial();
        Assert.assertSame(que1, ((NodeQueue) Q1).head);
    }

    @Test
    public void setHead_01() {
        setHead_initial();
        Q1.setHead(que2);
        Assert.assertSame(que2, ((NodeQueue) Q1).head);
    }

    @Test
    public void setHead_02() {
        setHead_initial();
        Q1.setHead(null);
        Assert.assertNull(((NodeQueue) Q1).head);
    }

//\\ getHead() \//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Override
    public void getHead_initial() {
        setHead_initial();
    }

    @Test
    public void getHead_01() {
        getHead_initial();
        Assert.assertSame(((NodeQueue) Q1).head, Q1.getHead());
    }

    @Test
    public void getHead_02() {
        getHead_initial();
        Assert.assertSame(((NodeQueue) Q1).head, ((Queueable) Q1).getHead());
    }

    @Test
    public void getHead_03() {
        getHead_initial();
        Assert.assertSame(((NodeQueue) Q1).head, ((Queuing) Q1).getHead());
    }

    @Test
    public void getHead_04() {
        getHead_initial();
        Assert.assertSame(((NodeQueue) Q1).head, ((NodeQueue) Q1).getHead());
    }

    @Test
    public void getHead_05() {
        getHead_initial();
        Assert.assertSame(((NodeQueue) Q1).head, ((Queueability) Q1).getHead());
    }

//\\ setTail(Queueable) //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Test
    public void setTail_initial() {
        Q1 = new NodeQueue(que1);
    }

    @Test
    public void setTail_00() {
        setTail_initial();
        Assert.assertSame(que1, ((NodeQueue) Q1).tail);
    }

    @Test
    public void setTail_01() {
        setTail_initial();
        Q1.setTail(que2);
        Assert.assertSame(que2, ((NodeQueue) Q1).tail);
    }

    @Test
    public void setTail_02() {
        setTail_initial();
        Q1.setTail(null);
        Assert.assertNull(((NodeQueue) Q1).tail);
    }

//\\ getTail() \//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Override
    public void getTail_initial() {
        setTail_initial();
    }

    @Test
    public void getTail_01() {
        getTail_initial();
        Assert.assertSame(((NodeQueue) Q1).tail, Q1.getTail());
    }

    @Test
    public void getTail_02() {
        getTail_initial();
        Assert.assertSame(((NodeQueue) Q1).tail, ((Queueable) Q1).getTail());
    }

    @Test
    public void getTail_03() {
        getTail_initial();
        Assert.assertSame(((NodeQueue) Q1).tail, ((Queuing) Q1).getTail());
    }

    @Test
    public void getTail_04() {
        getTail_initial();
        Assert.assertSame(((NodeQueue) Q1).tail, ((NodeQueue) Q1).getTail());
    }

    @Test
    public void getTail_05() {
        getTail_initial();
        Assert.assertSame(((NodeQueue) Q1).tail, ((Queueability) Q1).getTail());
    }
}