package input;

import org.junit.*;
import calculation.*;
import calculation.calculations.*;

public class QueueabilityTest {

    static Typical
            typ1 = NodeType.VALUE,
            typ2 = NodeType.EXPONENT,
            typ3 = NodeType.VALUE;
    static int
            ord1 = typ1.ordinal(),
            ord2 = typ2.ordinal(),
            ord3 = typ3.ordinal();
    static Nodeable
            nod1, nod2, nod3;
    static Queuer Q1;

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Before
    public void initial() {
        nod1 = typ1.interact();
        nod2 = typ2.interact();
        nod3 = typ3.interact();
        Q1 = new Queuer(nod1);
    }

    @After
    public void terminal() {
        nod1 = nod2 = nod3 = null;
        Q1 = null;
    }

    @Test
    public void initial_test() {
        Assert.assertTrue(nod1 instanceof Value);
        Assert.assertTrue(nod2 instanceof Calculation_Exponentiation);
        Assert.assertTrue(nod3 instanceof Value);
    }

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Test
    public void Queuer_head() {
        Assert.assertNull(Q1.getHead());
    }

    @Test
    public void Queuer_Tail() {
        Assert.assertNull(Q1.getTail());
    }
}