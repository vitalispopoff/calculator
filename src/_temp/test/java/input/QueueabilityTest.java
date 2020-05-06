package input;

import calculation.otherExpressions.Value;
import org.junit.*;
import calculation.*;
import calculation.calculations.*;

public class QueueabilityTest {

    static Typical
            typVal = NodeType.VALUE,
            typ2 = NodeType.EXPONENT;
    static Nodeable
            nod1, nod2, nod3;
    static Queuer que1;

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Before
    public void initial() {
        nod1 = new Value(typVal);
        nod2 = new Calculation_Exponentiation(typ2);
        nod3 = new Value(typVal);
        que1 = new Queuer(nod1);
    }

    @After
    public void terminal() {
        nod1 = nod2 = nod3 = null;
        que1 = null;
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
        Assert.assertNull(que1.getHead());
    }

    @Test
    public void Queuer_Tail() {
        Assert.assertNull(que1.getTail());
    }
}