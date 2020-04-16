package input;

import calculation.Node;
import calculation.Value;
import calculation.calculations.Calculation_Addition;
import org.junit.Assert;
import org.junit.Test;

public class QueuerTest {

    @Test
    public void Queuer_01() {
        Queuer q1 = new Queuer();
        Assert.assertNull(q1.prev);
        Assert.assertNull(q1.next);
        Assert.assertNull(q1.node);
    }

    @Test
    public void Queuer_02() {
        Queuer q0 = new Queuer();
        Queuer q1 = new Queuer(q0, null);
        Assert.assertSame(q0, q1.prev);
        Assert.assertNull(q1.next);
        Assert.assertNull(q1.node);
    }

    @Test
    public void Queuer_03() {
        Queuer q0 = new Queuer();
        Queuer q1 = new Queuer(q0, null);
        Assert.assertSame(q0, q1.prev);
        Assert.assertNull(q1.next);
        Assert.assertNull(q1.node);
    }

    @Test
    public void leaveQueue_01() {
        Node n2 = new Calculation_Addition();
        Queuer
                q1 = new Queuer(new Value(0.)),
                q2 = new Queuer(n2),
                q3 = new Queuer(new Value(0.));
        q1.setNext(q2);
        q2.setPrev(q1);
        q2.setNext(q3);
        q3.setPrev(q2);

        {
            Assert.assertSame(q2, q1.next);
            Assert.assertSame(q3, q2.next);
            Assert.assertSame(q1, q2.prev);
            Assert.assertSame(q2, q3.prev);
        }   // pretest

        Assert.assertSame(q3, q2.leaveQueue());

        Assert.assertNull(q2.prev);
        Assert.assertNull(q2.next);

        Assert.assertSame(q1, q3.prev);
        Assert.assertSame(q3, q1.next);
    }

    @Test
    public void leaveQueue_02() {
        Node n2 = new Calculation_Addition();
        Queuer
                q1 = new Queuer(new Value(0.)),
                q2 = new Queuer(n2);
        q1.setNext(q2);
        q2.setPrev(q1);

        Assert.assertSame(q2, q1.leaveQueue());
        Assert.assertNull(q2.prev);
    }

    @Test
    public void deQueuer_01() {
        Node n2 = new Calculation_Addition();
        Queuer
                q1 = new Queuer(new Value(0.)),
                q2 = new Queuer(n2),
                q3 = new Queuer(new Value(0.));
        q1.setNext(q2);
        q2.setPrev(q1);
        q2.setNext(q3);
        q3.setPrev(q2);

        /*{
            Assert.assertSame(q2, q1.next);
            Assert.assertSame(q3, q2.next);
            Assert.assertSame(q1, q2.prev);
            Assert.assertSame(q2, q3.prev);
        }*/   // pretest

        Assert.assertSame(n2, q2.deQueuer());

        /*{
            Assert.assertNull(q2.prev);
            Assert.assertNull(q2.next);
            Assert.assertNull(q2.node);
            Assert.assertSame(q1, q3.prev);
            Assert.assertSame(q3, q1.next);
        }*/   // posttest
    }

    @Test
    public void setPrev_01() {
        Queuer q0 = new Queuer();
        Queuer q1 = new Queuer();
        q1.setPrev(q0);
        Assert.assertSame(q0, q1.prev);
        Assert.assertSame(q1, q0.next);
    }

    @Test
    public void setNext_01() {
        Queuer q0 = new Queuer();
        Queuer q1 = new Queuer();
        q0.setNext(q1);
        Assert.assertSame(q1, q0.next);
        Assert.assertSame(q0, q1.prev);
    }

    @Test
    public void getNodesType_00() {
        Node val = new Value(0.);
        Queuer q1 = new Queuer(val);
        int result = val.getType().ordinal();
        Assert.assertEquals(result, q1.getNodeTypeOrdinal());
    }
}