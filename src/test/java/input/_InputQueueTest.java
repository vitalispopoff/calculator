package input;

import calculation.Node;
import calculation.Value;
import calculation.calculations.Calculation_Addition;
import calculation.calculations.Calculation_Exponentiation;
import org.junit.Assert;
import org.junit.Test;

public class _InputQueueTest {

    @Test
    public void _InputQueue_01() {
        Queuer q1 = new Queuer(new Value(0.));
        _InputQueue Q1 = new _InputQueue(q1);
        Assert.assertSame(q1, Q1.prev);
        Assert.assertSame(q1, Q1.next);
    }

    @Test
    public void _InputQueue_02() {
        Node val = new Value();
        _InputQueue Q1 = new _InputQueue(new Queuer(val));
        Assert.assertNotNull(Q1.nodePriorities);
        int i = val.getType().ordinal();
        Assert.assertEquals(1, Q1.nodePriorities[i]);
    }

    @Test
    public void _InputQueue_03() {
        Node add = new Calculation_Addition();
        _InputQueue Q1 = new _InputQueue(new Queuer(add));
        int i = add.getType().ordinal();
        Assert.assertEquals(1, Q1.nodePriorities[i]);
    }

    @Test
    public void addToQueue_01() {
        Queuer
                q1 = new Queuer(new Value()),
                q2 = new Queuer(new Value());
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
                q1 = new Queuer(new Value()),
                q2 = new Queuer(new Value());
        _InputQueue
                Q1 = new _InputQueue(q1);
        Q1.addToQueue(q2);

        Assert.assertSame(q1, Q1.prev);
        Assert.assertSame(q1, Q1.takeFromQueue());
        Assert.assertSame(q2, Q1.prev);
        Assert.assertNull(Q1.prev.prev);
        Assert.assertNull(q1.next);
    }

    @Test
    public void takeFromQueue_02() {
        Queuer
                q1 = new Queuer(new Value()),
                q2 = new Queuer(new Value());
        _InputQueue
                Q1 = new _InputQueue(q1);
        Assert.assertEquals(1, Q1.getLength());

        Q1.addToQueue(q2);
        Assert.assertEquals(2, Q1.getLength());
        Assert.assertSame(q1, Q1.prev);
        Assert.assertSame(q2, Q1.next);

        Assert.assertSame(q1, Q1.takeFromQueue());
        Assert.assertSame(q2, Q1.prev);
        Assert.assertEquals(1, Q1.getLength());
    }

    @Test
    public void takeFromQueue_03() {
        Queuer
                q1 = new Queuer(new Value());
        _InputQueue
                Q1 = new _InputQueue(q1);
        Q1.takeFromQueue();
        Assert.assertEquals(0, Q1.getLength());
        Assert.assertNull(Q1.takeFromQueue());
    }

    @Test
    public void takeFromQueue_04(){
        Queuer
                q1 = new Queuer(new Value()),
                q2 = new Queuer(new Calculation_Exponentiation());
        _InputQueue
                Q1 = new _InputQueue(q1);
        Assert.assertEquals(1,Q1.nodePriorities[q1.getNodesType()]);
        Assert.assertEquals(0, Q1.nodePriorities[q2.getNodesType()]);

        Q1.addToQueue(q2);
        Assert.assertEquals(1,Q1.nodePriorities[q2.getNodesType()]);

        int i1 = ((Queuer)Q1.takeFromQueue()).getNodesType();
        Assert.assertEquals(0, Q1.nodePriorities[i1]);
        Assert.assertEquals(1,Q1.nodePriorities[q2.getNodesType()]);

        int i2 = ((Queuer)Q1.takeFromQueue()).getNodesType();
        Assert.assertEquals(0, Q1.nodePriorities[i2]);
    }
}