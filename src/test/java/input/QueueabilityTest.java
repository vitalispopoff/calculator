package input;

import org.junit.Assert;
import org.junit.Test;
import calculation.*;
import calculation.calculations.Calculation_Exponentiation;

public class QueueabilityTest {

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
//  @formatter:off

    @Test public void Queuer_head(){
        Assert.assertNull(Q1.getHead());
    }
    @Test public void Queuer_Tail(){
        Assert.assertNull(Q1.getTail());
    }

    //  @formatter:on


}
