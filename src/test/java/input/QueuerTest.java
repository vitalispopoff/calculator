package input;

import calculation.*;
import calculation.calculations.Calculation_Exponentiation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueuerTest {

    static Typical
            typ1,
            typ2,
            typ3;
    static Nodeable
            nod1,
            nod2,
            nod3;
    static Queuer
            que1,
            que2,
            que3;
    static Queueable
            Q1;

    @Before
    public void setup_01() {
        typ1 = NodeType.VALUE;
        nod1 = new Value(typ1);
        que1 = new Queuer(nod1);
        Q1 = new CalculationQueue(que1);
    }

    static private void setup_02() {
        que1.postOne = que1;
        que1.deQueuer();
    }

    static private void setup_03() {
        typ2 = NodeType.EXPONENT;
        nod2 = new Calculation_Exponentiation(typ2);
        que2 = new Queuer(nod2);
    }

    static private void setup_04(){
        setup_03();
        que2.joinQueue(Q1);
    }

    @Test
    public void Node_01() {
        Assert.assertNull(que1.prevOne);
    }

    @Test
    public void Node_02() {
        Assert.assertNull(que1.postOne);
    }

    @Test
    public void Node_03() {
        Assert.assertSame(nod1, que1.node);
    }

    @Test
    public void deQueuer_01() {
        Assert.assertSame(nod1, que1.deQueuer());
    }

    @Test
    public void deQueuer_02() {
        setup_02();
        Assert.assertNull(que1.node);
    }

    @Test
    public void deQueuer_04() {
        setup_02();
        Assert.assertNull(que1.postOne);
    }

    @Test
    public void getNodeTypeOrdinal_01() {
        int result = typ1.ordinal();
        Assert.assertEquals(result, que1.getNodeTypeOrdinal());
    }

    @Test
    public void getNodeTypeOrdinal_02() {
        que1.node = null;
        Assert.assertEquals(-1, que1.getNodeTypeOrdinal());
    }

    @Test
    public void joinQueue_01() {
        setup_03();
        que2.joinQueue(Q1);
        Assert.assertSame(que1, que2.prevOne);
    }

    @Test
    public void joinQueue_02(){
        setup_03();
        que2.joinQueue(Q1);
        Assert.assertSame(que1.postOne, que2);
    }

    @Test
    public void  leaveQueue_01(){
        Assert.assertSame(que2, que1.leaveQueue());
        Assert.assertNull(que1.postOne);
    }
}