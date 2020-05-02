package input;

import _notes._QueuingTest_Notes;
import calculation.*;
import org.junit.*;

import static memory.Memory.mainQueue;

public class QueuingTest implements _QueuingTest_Notes {

    static Typical
            typVal, typ2, typ4, typ6;
    static Nodeable
            nod1, nod2, nod3, nod4, nod5, nod6, nod7;
    static int
            ord1;
    static Enqueued
            que1, que2, que3, que4, que5, que6, que7;

    static {
        typVal = NodeType.VALUE;
        typ2 = NodeType.SUBTRACT;
        typ4 = NodeType.EXPONENT;
        typ6 = NodeType.ADD;
        nod1 = typVal.interact();
        nod2 = typ2.interact();
        nod3 = typVal.interact();
        nod4 = typ4.interact();
        nod5 = typVal.interact();
        nod6 = typ6.interact();
        nod7 = typVal.interact();
        ord1 = typVal.getTypePriority();
        nod1.setValue(2.);
        nod3.setValue(2.);
        nod5.setValue(0.);
        nod7.setValue(1.);
    }

//\\ support methods /\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Before
    public void initial() {
        que1 = new Queuer(nod1);
        que2 = new Queuer(nod3);
        que3 = new Queuer(nod3);
        que4 = new Queuer(nod4);
        que5 = new Queuer(nod5);
        que6 = new Queuer(nod6);
        que7 = new Queuer(nod7);
    }

    @After
    public void terminal() {
        que3 = que4 = que5 = que6 = que7 = null;
        mainQueue = new NodeQueue(null);
    }

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Override
    public void convertToLocalTree_initial() {
        mainQueue = new NodeQueue(null);
        mainQueue.updateQueue(que3);
        mainQueue.updateQueue(que4);
        mainQueue.updateQueue(que5);
        mainQueue.updateQueue(que6);
        mainQueue.updateQueue(que7);
    }

    private void convertToLocalTree_init01() {
        initial();
        mainQueue = new NodeQueue(null);
        mainQueue.updateQueue(que1);
        mainQueue.updateQueue(que2);
        mainQueue.updateQueue(que3);
        mainQueue.updateQueue(que4);
        mainQueue.updateQueue(que5);
        mainQueue.updateQueue(que6);
        mainQueue.updateQueue(que7);
    }

    @Test
    public void constructLocalSubTree_initial_00() {
        convertToLocalTree_initial();
        Assert.assertSame(que3, mainQueue.getHead());
        Assert.assertSame(que7, mainQueue.getTail());
        Assert.assertSame(que6, mainQueue.getTail().getHead());
        Assert.assertSame(que6, mainQueue.getHead().getTail().getTail().getTail());
        Assert.assertEquals(4, ord1);
    }

    @Test
    public void convertToLocalTree_01() {
        convertToLocalTree_initial();
        mainQueue.convertToLocalTree(mainQueue.updateQueue());
        Assert.assertSame(que6, mainQueue.getHead());
    }

    @Test
    public void convertToLocalTree_02() {
        convertToLocalTree_initial();
        mainQueue.convertToLocalTree(mainQueue.updateQueue());
        Assert.assertSame(nod4, ((Enqueued) mainQueue.getHead()).getNode().getLocalLeft());
        Assert.assertSame(nod3, nod4.getLocalLeft());
        Assert.assertSame(nod5, nod4.getLocalRite());
        Assert.assertSame(nod7, ((Enqueued) mainQueue.getHead()).getNode().getLocalRite());
    }

    @Test
    public void convertToLocalTree_03() {
        convertToLocalTree_initial();
        mainQueue.convertToLocalTree(mainQueue.updateQueue());
        Assert.assertEquals(NodeType.VALUE.getTypePriority(), mainQueue.getCounter());
    }

    @Test
    public void convertToLocalTree_04() {
        convertToLocalTree_initial();
        mainQueue.convertToLocalTree(mainQueue.updateQueue());
        Assert.assertSame(mainQueue.getHead(), mainQueue.getTail());
        Assert.assertNotNull(mainQueue.getHead());
    }

    @Test
    public void convertToLocalTree_05() {
        convertToLocalTree_initial();
        mainQueue.convertToLocalTree(mainQueue.updateQueue());
        Nodeable result = ((Enqueued) mainQueue.getHead()).getNode();
        Double value = result.getValue();
        Assert.assertEquals(2., value, 0.);
    }

    @Test
    public void convertToLocalTree_06() {
        convertToLocalTree_init01();
        mainQueue.convertToLocalTree(mainQueue.updateQueue());
        Nodeable result = ((Enqueued) mainQueue.getHead()).getNode();
        Double value = result.getValue();
        Assert.assertEquals(2., value, 0.);
    }

    @Test
    public void convertToTree_01() {
        convertToLocalTree_init01();
        mainQueue.convertToTree();
        Nodeable result = ((Enqueued) mainQueue.getHead()).getNode();
        Double value = result.getValue();
        Assert.assertEquals(2., value, 0.);
    }

//\\ updateQueue() \//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Override
    public void updateQueue_Ext_initial() {
        mainQueue = new NodeQueue(que3);
        ((Queuer) que3).tail = que4;
        ((Queuer) que4).head = que3;
        ((NodeQueue) mainQueue).tail = que4;
    }

    @Test
    public void updateQueue_ext_00() {
        updateQueue_Ext_initial();
        Assert.assertSame(que3, mainQueue.getHead());
        Assert.assertSame(que4, mainQueue.getTail());
        Assert.assertSame(que4, que3.getTail());
        Assert.assertSame(que3, que4.getHead());
        Assert.assertNull(que3.getHead());
        Assert.assertNull(que4.getTail());
    }

    @Test
    public void updateQueue_ext_01() {
        updateQueue_Ext_initial();
        Assert.assertSame(que3, mainQueue.updateQueue());
    }

    @Test
    public void updateQueue_ext_02() {
        updateQueue_Ext_initial();
        Queueable
                expectation = mainQueue.getHead().getTail();
        System.out.println("   queue head is  que2 : " + (mainQueue.getHead().getTail() == que4));
        System.out.println("   method return's tail is que2 : " + (mainQueue.updateQueue().getTail() == que4));
        System.out.println("   after method Q1 head is que2 :" + (mainQueue.getHead() == que4));
        Assert.assertSame(que4, mainQueue.getHead());
        Queueable
                result = mainQueue.getHead();
        Assert.assertSame(expectation, result);

    }

    @Test
    public void updateQueue_ext_03() {
        updateQueue_Ext_initial();
        mainQueue.updateQueue();
        Assert.assertNull(mainQueue.getHead().getHead());
    }

    @Test
    public void updateQueue_ext_04() {
        updateQueue_Ext_initial();
        Assert.assertNull(mainQueue.updateQueue().getTail());
    }

    @Test
    public void updatedQueue_ext_06() {
        mainQueue.updateQueue();
        Assert.assertNull(mainQueue.getHead());
    }

    @Test
    public void updateQueue_ext_07() {
        mainQueue.updateQueue();
        Assert.assertNull(mainQueue.getTail());
    }

    @Test
    public void updatedQueue_ext08() {
        mainQueue.updateCounter();
        Assert.assertEquals(0, mainQueue.getCounter(mainQueue.getHead()));
    }


    @Test
    public void updateQueue_ext_09() {
        mainQueue.updateQueue();
        Assert.assertNull(mainQueue.updateQueue());
    }

//\\ updateQueue(Queueable) //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Override
    public void updateQueue_Add_initial() {
        mainQueue = new NodeQueue(que3);
    }

    @Test
    public void updateQueue_Add_01() {
        updateQueue_Add_initial();
        System.out.println("   Is que1 a Q1's tail : " + (mainQueue.getTail() == que3));
        Queueable cache = mainQueue.getTail();
        mainQueue.updateQueue(que4);
        Assert.assertSame(cache, que4.getHead());
    }

    @Test
    public void updatedQueue_Add_02() {
        updateQueue_Add_initial();
        Queueable cache = mainQueue.getTail();
        mainQueue.updateQueue(que4);
        Assert.assertSame(que4, cache.getTail());
    }

    @Test
    public void updateQueue_Add_03() {
        updateQueue_Add_initial();
        mainQueue.updateQueue(que4);
        Assert.assertSame(que4, mainQueue.getTail());
    }

    @Test
    public void updateQueue_Add_05() {
        mainQueue = new NodeQueue(null);
        mainQueue.updateQueue(que4);
        Assert.assertNull(mainQueue.getHead().getTail());
    }

    @Test
    public void updateQueue_Add_06() {
        mainQueue = new NodeQueue(null);
        mainQueue.updateQueue(que4);
        Assert.assertNull(mainQueue.getTail().getHead());
    }

    @Test
    public void updateQueue_Add_07() {
        mainQueue.updateQueue(que4);
        Assert.assertSame(que4, mainQueue.getHead());
    }

    @Test
    public void updateQueue_Add_08() {
        mainQueue.updateQueue(que4);
        Assert.assertSame(que4, mainQueue.getTail());
    }

    @Test
    public void updatedQueue_Add_09() {
        mainQueue.updateQueue(que4);
        Assert.assertEquals(1, mainQueue.getCounter(mainQueue.getHead()));

    }

//\\ getCounter //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Override
    public void getCounter_initial(int ord, int val) {
        mainQueue = new NodeQueue(que1);
        ((NodeQueue) mainQueue).nodeCounter[ord] = val;
    }

    @Test
    public void getCounter_01() {
        getCounter_initial(ord1, 1);
        Assert.assertEquals(1, mainQueue.getCounter(mainQueue.getHead()));
    }

    @Test
    public void getCounter_02() {
        Assert.assertEquals(0, mainQueue.getCounter(null));
    }

//\\ updateCounter(Typical) //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Override
    public void updateCounter_Add_initial() {
    }

    @Test
    public void updateCounter_Add_01() {
        ((NodeQueue) mainQueue).head = ((NodeQueue) mainQueue).tail = que1;
        mainQueue.updateCounter(mainQueue.getHead());
        Assert.assertEquals(1, mainQueue.getCounter(mainQueue.getHead()));
    }

//\\ update Counter() \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Override
    public void updateCounter_Ext_initial() {
    }

    @Test
    public void updateCounter_Ext_01() {
        getCounter_initial(ord1, 1);
        mainQueue.updateCounter();
        Assert.assertEquals(0, mainQueue.getCounter(mainQueue.getHead()));
    }

    @Test
    public void updateCounter_Ext_02() {
        mainQueue.updateCounter();
        Assert.assertEquals(0, mainQueue.getCounter(mainQueue.getHead()));
    }

//\\ setHead(Queueable) //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Override
    public void setHead_initial() {
        mainQueue = new NodeQueue(que3);
    }

    @Test
    public void setHead_00() {
        setHead_initial();
        Assert.assertSame(que3, ((NodeQueue) mainQueue).head);
    }

    @Test
    public void setHead_01() {
        setHead_initial();
        mainQueue.setHead(que4);
        Assert.assertSame(que4, ((NodeQueue) mainQueue).head);
    }

    @Test
    public void setHead_02() {
        setHead_initial();
        mainQueue.setHead(null);
        Assert.assertNull(((NodeQueue) mainQueue).head);
    }

//\\ getHead() \//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Override
    public void getHead_initial() {
        setHead_initial();
    }

    @Test
    public void getHead_01() {
        getHead_initial();
        Assert.assertSame(((NodeQueue) mainQueue).head, mainQueue.getHead());
    }

    @Test
    public void getHead_02() {
        getHead_initial();
        Assert.assertSame(((NodeQueue) mainQueue).head, ((Queueable) mainQueue).getHead());
    }

    @Test
    public void getHead_03() {
        getHead_initial();
        Assert.assertSame(((NodeQueue) mainQueue).head, ((Queuing) mainQueue).getHead());
    }

    @Test
    public void getHead_04() {
        getHead_initial();
        Assert.assertSame(((NodeQueue) mainQueue).head, ((NodeQueue) mainQueue).getHead());
    }

    @Test
    public void getHead_05() {
        getHead_initial();
        Assert.assertSame(((NodeQueue) mainQueue).head, ((Queueability) mainQueue).getHead());
    }

//\\ setTail(Queueable) //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Test
    public void setTail_initial() {
        mainQueue = new NodeQueue(que3);
    }

    @Test
    public void setTail_00() {
        setTail_initial();
        Assert.assertSame(que3, ((NodeQueue) mainQueue).tail);
    }

    @Test
    public void setTail_01() {
        setTail_initial();
        mainQueue.setTail(que4);
        Assert.assertSame(que4, ((NodeQueue) mainQueue).tail);
    }

    @Test
    public void setTail_02() {
        setTail_initial();
        mainQueue.setTail(null);
        Assert.assertNull(((NodeQueue) mainQueue).tail);
    }

//\\ getTail() \//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Override
    public void getTail_initial() {
        setTail_initial();
    }

    @Test
    public void getTail_01() {
        getTail_initial();
        Assert.assertSame(((NodeQueue) mainQueue).tail, mainQueue.getTail());
    }

    @Test
    public void getTail_02() {
        getTail_initial();
        Assert.assertSame(((NodeQueue) mainQueue).tail, ((Queueable) mainQueue).getTail());
    }

    @Test
    public void getTail_03() {
        getTail_initial();
        Assert.assertSame(((NodeQueue) mainQueue).tail, ((Queuing) mainQueue).getTail());
    }

    @Test
    public void getTail_04() {
        getTail_initial();
        Assert.assertSame(((NodeQueue) mainQueue).tail, ((NodeQueue) mainQueue).getTail());
    }

    @Test
    public void getTail_05() {
        getTail_initial();
        Assert.assertSame(((NodeQueue) mainQueue).tail, ((Queueability) mainQueue).getTail());
    }
}