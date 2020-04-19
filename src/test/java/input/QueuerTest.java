package input;

import org.junit.Assert;
import org.junit.Test;

public class QueuerTest {

    @Test
    public void Queuer_01() {
        Queueable
                q = new Queuer();
        Assert.assertNull(q.getPrevOne());
        Assert.assertNull(q.getPrevOne());
        Assert.assertNull(q.getNode());
    }

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

    @Test
    public void leaveQueue_01() {
        Queueable
                q1 = new Queuer(),
                q2 = new Queuer(),
                Q1 = new CalculationQueue(q1);
        q2.joinQueue(Q1);
        Assert.assertSame(q2, ((Queuer) q1).postOne);
        Assert.assertSame(q2,q1.leaveQueue());
        Assert.assertNull(((Queuer) q1).prevOne);
        Assert.assertNull(((Queuer) q1).postOne);
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