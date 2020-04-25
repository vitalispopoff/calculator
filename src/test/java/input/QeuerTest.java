package input;

import calculation.*;
import calculation.calculations.Calculation_Exponentiation;
import org.junit.Assert;
import org.junit.Test;

public class QeuerTest {

    static Typical
            typ1 = NodeType.VALUE,
            typ2 = NodeType.EXPONENT,
            typ3 = NodeType.VALUE;
    static Nodeable
            node1 = typ1.interact(),
            node2 = typ2.interact(),
            node3 = typ3.interact();
    static int
            ord1 = typ1.ordinal(),
            ord2 = typ2.ordinal(),
            ord3 = typ3.ordinal();
    static Queuer Q1 = new Queuer(node1);

    @Test
    public void setup_() {
        Assert.assertTrue(node1 instanceof Value);
        Assert.assertTrue(node2 instanceof Calculation_Exponentiation);
        Assert.assertTrue(node3 instanceof Value);
    }

    //    @formatter:off

    @Test public void Queuer_head(){
        Assert.assertNull(Q1.getHead());
    }
    @Test public void Queuer_Tail(){
        Assert.assertNull(Q1.getTail());
    }
    @Test public void Queuer_Node() { Assert.assertNotNull(Q1.getNode());}
    @Test public void Queuer_Type() { Assert.assertSame(typ1, Q1.getType());}
    @Test public void Queuer_TypeOrdinal() { Assert.assertEquals(ord1, Q1.getTypeOrdinal());}

//    @formatter:on
}