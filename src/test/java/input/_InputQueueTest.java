package input;

import org.junit.Assert;
import org.junit.Test;

public class _InputQueueTest {

    @Test
    public void _InputQueue_01() {
        Queuer q1 = new Queuer();
        _InputQueue Q1 = new _InputQueue(q1);
        Assert.assertSame(q1, Q1.prev);
        Assert.assertSame(q1, Q1.next);
    }

    @Test
    public void addToQueue_01() {
        Queuer
                q1 = new Queuer(),
                q2 = new Queuer();
        _InputQueue
                Q1 = new _InputQueue(q1);
        Assert.assertSame(q1, Q1.prev);
        Assert.assertSame(q1, Q1.next);
        Q1.addToQueue(q2);
        Assert.assertSame(q1, Q1.prev);
        Assert.assertSame(q2, Q1.next);
    }

    @Test
    public void takeFromQueue_01() {
        Queuer
                q1 = new Queuer(),
                q2 = new Queuer();
        _InputQueue
                Q1 = new _InputQueue(q1);
        Q1.addToQueue(q2);
        Assert.assertSame(q1, Q1.prev);
        Assert.assertSame(q1, Q1.takeFromQueue());
        Assert.assertSame(q2, Q1.prev);
        Assert.assertNull(Q1.prev.prev);
        Assert.assertNull(q1.next);
    }
}