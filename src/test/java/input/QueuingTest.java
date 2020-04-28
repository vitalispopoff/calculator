package input;

import calculation.*;
import org.junit.*;

public class QueuingTest implements QueuingTestNotes {

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

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Override
    public void updateQueue_issue() {
    }

    @Override
    public void updateQueue_Ext_initial() {
        Q1 = new NodeQueue(que1);
        ((Queuer) que1).tail = que2;
        ((Queuer) que2).head = que1;
        ((NodeQueue) Q1).tail = que2;
    }

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

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
        Assert.assertNull(Q1.getHead().getHead());  // is false - should be true
    }

    @Test
    public void updateQueue_ext_04(){
        updateQueue_Ext_initial();
        Assert.assertNull(Q1.updateQueue().getTail());
    }

    @Test
    public void updatedQueue_ext_06(){
        Q1 = new NodeQueue(que1);
        Q1.updateQueue();
        Assert.assertNull(Q1.getHead());
    }

    @Test
    public void updateQueue_ext_07(){
        Q1 = new NodeQueue(que1);
        Q1.updateQueue();
        Assert.assertNull(Q1.getTail());
    }

    @Test
    public void updateQueue_ext_08(){
        Q1 = new NodeQueue(que1);
        Q1.updateQueue();
        Assert.assertNull(Q1.updateQueue());

    }

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\










//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//

    /**
     * setHead tests:<br>
     * 0.  constructor sets head<br>
     * 1.  setter sets head<br>
     * 2.  setter sets null<br>
     */
    private void setHead_initial() {
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

    /**
     * getHead tests:<br>
     * 1. get as default cast<br>
     * 2. get as Queueable cast<br>
     * 3. get as Queuing cast<br>
     * 4. get as NodeQueue cast<br>
     * 5. get as NodeQueue cast<br>
     */
    private void getHead_initial() {
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

    /**
     * setTail tests:<br>
     * 0.  constructor sets tail<br>
     * 1.  setter sets tail<br>
     * 2.  setter sets null<br>
     */
    private void setTail_initial() {
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

    /**
     * getTail tests:<br>
     * 1. get as default cast<br>
     * 2. get as Queueable cast<br>
     * 3. get as Queuing cast<br>
     * 4. get as NodeQueue cast<br>
     * 5. get as NodeQueue cast<br>
     */
    private void getTail_initial() {
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