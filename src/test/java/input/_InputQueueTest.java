package input;

import calculation.Node;
import calculation.NodeType;
import calculation.Value;
import calculation.calculations.Calculation_Addition;
import calculation.calculations.Calculation_Exponentiation;
import calculation.calculations.Calculation_Multiplication;
import org.junit.Assert;
import org.junit.Ignore;
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
        Assert.assertNotNull(Q1.enlistedNodeTypes);
        int i = val.getType().ordinal();
        Assert.assertEquals(1, Q1.enlistedNodeTypes[i]);
    }

    @Test
    public void _InputQueue_03() {
        Node add = new Calculation_Addition();
        _InputQueue Q1 = new _InputQueue(new Queuer(add));
        int i = add.getType().ordinal();
        Assert.assertEquals(1, Q1.enlistedNodeTypes[i]);
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
    public void addToQueue_02() {
        Node
                n0 = new Value(),
                n2 = new Calculation_Multiplication(),
                n4 = new Value(),
                n5 = new Value();
        n0.type = NodeType.BRACKET_IN_OUT;
        n5.type = NodeType.EVAL;
        Queuer
                q0 = new Queuer(n0),
                q4 = new Queuer(n4);
        _InputQueue
                Q = new _InputQueue(new Queuer(n5));
        Assert.assertEquals(n5.type.ordinal(), Q.getNodeTypeOrdinal());
        Q.addToQueue(q4);
        Assert.assertEquals(n4.type.ordinal(), Q.getNodeTypeOrdinal());
        Q.addToQueue(new Queuer(n2));
        Assert.assertEquals(n2.type.ordinal(), Q.getNodeTypeOrdinal());
        Q.addToQueue(q0);
        Assert.assertEquals(n0.type.ordinal(), Q.getNodeTypeOrdinal());

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
    public void takeFromQueue_04() {
        Queuer
                q1 = new Queuer(new Value()),
                q2 = new Queuer(new Calculation_Exponentiation());
        _InputQueue
                Q1 = new _InputQueue(q1);
        Assert.assertEquals(1, Q1.enlistedNodeTypes[q1.getNodeTypeOrdinal()]);
        Assert.assertEquals(0, Q1.enlistedNodeTypes[q2.getNodeTypeOrdinal()]);

        Q1.addToQueue(q2);
        Assert.assertEquals(1, Q1.enlistedNodeTypes[q2.getNodeTypeOrdinal()]);

        int i1 = ((Queuer) Q1.takeFromQueue()).getNodeTypeOrdinal();
        Assert.assertEquals(0, Q1.enlistedNodeTypes[i1]);
        Assert.assertEquals(1, Q1.enlistedNodeTypes[q2.getNodeTypeOrdinal()]);

        int i2 = ((Queuer) Q1.takeFromQueue()).getNodeTypeOrdinal();
        Assert.assertEquals(0, Q1.enlistedNodeTypes[i2]);
    }

    @Test
    public void getCurrentNodePriority_00() {
        Queuer
                q1 = new Queuer(new Calculation_Exponentiation()),
                q2 = new Queuer(new Value(0.));
        _InputQueue Q1 = new _InputQueue(q1);
        Assert.assertEquals(q1.getNodeTypeOrdinal(), Q1.getNodeTypeOrdinal());
    }

    @Test
    public void getCurrentNodePriority_01() {
        Node
                n0 = new Value(),
                n4 = new Value();
        n0.type = NodeType.BRACKET_IN_OUT;
        n4.type = NodeType.VAL;
        _InputQueue Q = new _InputQueue(new Queuer(n4));
        Assert.assertEquals(n4.type.ordinal(), Q.getNodeTypeOrdinal());

        Q.addToQueue(new Queuer(n0));
        Assert.assertEquals(n0.type.ordinal(), Q.getNodeTypeOrdinal());
    }

    @Ignore
    @Test   // ! out of date
    public void extractNodeForLocalTree_01() {
        Node
                n1 = new Value(1.),
                n2 = new Calculation_Addition(),
                n3 = new Value(-1.);
        Queuer
                q1 = new Queuer(n1),
                q2 = new Queuer(n2),
                q3 = new Queuer(n3);
        _InputQueue Q1 = new _InputQueue(q1);
        Q1.addToQueue(q2);
        Q1.addToQueue(q3);

        Assert.assertEquals(3, Q1.length);
        Assert.assertSame(q1, Q1.prev);
        Assert.assertSame(q3, Q1.next);
        Assert.assertSame(q2, q1.next);
        Assert.assertNull(Q1.node);

        Q1.convertToLocalTree();
        Assert.assertSame(q1, Q1.prev);
    }

    @Ignore
    @Test   // ! out of date
    public void extractNodeForLocalTree_02() {
        Node
                n1 = new Value(1.),
                n2 = new Calculation_Addition(),
                n3 = new Value(-1.),
                n4 = new Calculation_Multiplication(),
                n5 = new Value(0.);

        Queuer
                q1 = new Queuer(n1),
                q2 = new Queuer(n2),
                q3 = new Queuer(n3),
                q4 = new Queuer(n4),
                q5 = new Queuer(n5);
        _InputQueue Q1 = new _InputQueue(q1);
        Q1.addToQueue(q2);
        Q1.addToQueue(q3);
        Q1.addToQueue(q4);
        Q1.addToQueue(q5);

        Q1.convertToLocalTree();
        Assert.assertSame(q3, Q1.prev);
    }

    @Ignore
    @Test   // ! ouf of date
    public void extractNodeForLocalTree_03() {
        Node
                n1 = new Value(1.),
                n2 = new Calculation_Multiplication(),
                n3 = new Value(-1.),
                n4 = new Calculation_Addition(),
                n5 = new Value(0.);
        Queuer
                q1 = new Queuer(n1),
                q2 = new Queuer(n2),
                q3 = new Queuer(n3),
                q4 = new Queuer(n4),
                q5 = new Queuer(n5);
        _InputQueue Q1 = new _InputQueue(q3);
        Q1.addToQueue(q4);
        Q1.addToQueue(q5);
        Q1.addToQueue(q1);
        Q1.addToQueue(q2);

        Q1.convertToLocalTree();
        Assert.assertSame(q1, Q1.prev);
    }

//    @Ignore
    @Test
    public void extractNodeForLocalTree_04() {
        Node
                n1 = new Value(1.),
                n2 = new Calculation_Multiplication(),
                n3 = new Value(-1.),
                n4 = new Calculation_Addition(),
                n5 = new Value(0.);
        Queuer
                q1 = new Queuer(n1),
                q2 = new Queuer(n2),
                q3 = new Queuer(n3),
                q4 = new Queuer(n4),
                q5 = new Queuer(n5);
        _InputQueue Q1 = new _InputQueue(q1);
        Q1.addToQueue(q2);
        Q1.addToQueue(q3);
        Q1.addToQueue(q4);
        Q1.addToQueue(q5);

        double result = n1.value * n3.value;

        Q1.convertToLocalTree();
        Assert.assertSame(q4, Q1.prev);
        Assert.assertSame(q2,Q1.next);
        Assert.assertSame(q2.getNodeTypeOrdinal(), NodeType.VAL.ordinal());
        Assert.assertSame(q4.getNodeTypeOrdinal(), Q1.getNodeTypeOrdinal());
        Assert.assertEquals(3, Q1.length);
        Assert.assertEquals(result, Q1.next.getNode().value, 0.);
    }

    @Test
    public void extractNodeForLocalTree_05() {
        Node
                n1 = new Value(1.),
                n2 = new Calculation_Multiplication(),
                n3 = new Value(-1.),
                n4 = new Calculation_Addition(),
                n5 = new Value(0.);
        Queuer
                q1 = new Queuer(n1),
                q2 = new Queuer(n2),
                q3 = new Queuer(n3),
                q4 = new Queuer(n4),
                q5 = new Queuer(n5);
        _InputQueue Q1 = new _InputQueue(q1);
        Q1.addToQueue(q2);
        Q1.addToQueue(q3);
        Q1.addToQueue(q4);
        Q1.addToQueue(q5);

        Q1.convertToLocalTree();
        Assert.assertEquals(-1.,q2.getNode().value,0.);

    }
}