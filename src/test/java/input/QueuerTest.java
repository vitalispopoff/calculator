package input;

import calculation.NodeType;
import calculation.Nodeable;
import calculation.Value;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;

public class QueuerTest {

    @Ignore
    @Test
    public void Queuer_01() {
        Queueable
                q = new Queuer();
        Assert.assertNull(q.getPrevOne());
        Assert.assertNull(q.getPrevOne());
        Assert.assertNull(q.getNode());
    }

    @Ignore
    @Test
    public void joinQueue_01() {
        Queueable
                q1 = new Queuer(),
                q2 = new Queuer(),
                Q1 = new CalculationQueue(q1);
        Assert.assertSame(q1, ((CalculationQueue) Q1).prevOne);
        Assert.assertSame(q1, ((CalculationQueue) Q1).postOne);
        q2.joinQueue(Q1);
        Assert.assertSame(q1, ((CalculationQueue) Q1).prevOne);
        Assert.assertSame(q2, ((CalculationQueue) Q1).postOne);
    }

    @Ignore
    @Test
    public void joinQueue_02() {
        Queueable
                q1 = new Queuer(),
                q2 = new Queuer(),
                Q1 = new CalculationQueue(q1);
        q2.joinQueue(Q1);
        Assert.assertSame(q1, ((Queuer) q2).prevOne);
        Assert.assertSame(q2, ((Queuer) q1).postOne);
    }

    @Ignore
    @Test
    public void leaveQueue_01() {
        Queueable
                q1 = new Queuer(),
                q2 = new Queuer(),
                Q1 = new CalculationQueue(q1);
        q2.joinQueue(Q1);
        Assert.assertSame(q2, ((Queuer) q1).postOne);
        Assert.assertSame(q2, q1.leaveQueue());
        Assert.assertNull(((Queuer) q1).prevOne);
        Assert.assertNull(((Queuer) q1).postOne);
    }

    @Ignore
    @Test
    public void deQueuer_01() {
        Nodeable n1 = new Value(NodeType.VALUE);
        Queueable q1 = new Queuer();
        ((Queuer) q1).setNode(n1);
        Assert.assertSame(n1, ((Queuer) q1).node);
        Assert.assertSame(n1, q1.deQueuer());
        Assert.assertNull(((Queuer) q1).postOne);
        Assert.assertNull(((Queuer) q1).prevOne);
        Assert.assertNull(((Queuer) q1).node);
    }

    @Ignore
    @Test
    public void getNodeTypeOrdinal_01(){
        NodeType t1 = NodeType.VALUE;
        Nodeable n1 = new Value(t1);
        Queueable q1 = new Queuer();
        ((Queuer)q1).node = n1;
        Assert.assertEquals(t1.ordinal(), q1.getNodeTypeOrdinal());
    }

    @Ignore
    @Test
    public void getNodeTypeOrdinal_02(){
        int typePick = new Random().nextInt(NodeType.values().length);
        NodeType t1 = NodeType.values()[typePick];
        Nodeable n1 = new Value(t1);
        Queueable q1 = new Queuer();
        ((Queuer)q1).node = n1;
        Assert.assertEquals(t1.ordinal(), q1.getNodeTypeOrdinal());

    }

    @Ignore
    @Test
    public void getNodeTypeOrdinal_03(){
        Queueable q1 = new Queuer();
        Assert.assertEquals(-1, q1.getNodeTypeOrdinal());
    }





}
/*
 *   adding a queuer to the queue
 *
 *   Upon wishing to join the queue, the queuer sends request
 *   and receives an answer with info about current last queuer inline
 *   (CalculationQueue.postOne)
 *   The queuer updates its prevOne.
 *
 *   The queue requests the current last queuer to updated its postOne
 *   and does the same itself.
 * */    //  ?   adding a queuer to the queue
/*
 *   removing a queuer from the queue
 *
 *   upon leaving the queue, the queuer is asked by the queue
 *   and to updated its postOne right after informing
 *   the postOne to do the same with its prevOne:
 *   postOne.setPrevOne(null);
 *   setPostOne(null);
 *
 *   on its side the queue receiving the link to its prevOne postOne
 *   updates own prevOne
 *   setPrevOne(prevOne.getPostOne());
 *
 * */    //  ?   removing a queuer from the queue