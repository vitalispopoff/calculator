package input;

import org.junit.*;
import calculation.*;
import calculation.calculations.*;

public class QueuerTest {

    static Typical
            typ1 = NodeType.VALUE,
            typ2 = NodeType.EXPONENT,
            typ3 = NodeType.VALUE;
    static Nodeable
            nod1 = typ1.interact(),
            nod2 = typ2.interact(),
            nod3 = typ3.interact();
    static int
            ord1, ord2, ord3;
    static Queuer Q1;

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Before
    public void initial() {
        ord1 = typ1.getTypePriority();
        Q1 = new Queuer(nod1);
    }

    @After
    public void terminal() {
        Q1 = null;
    }

    @Test
    public void initial_test() {
//        Assert.assertEquals(4, ord1);
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

    @Test
    public void Queuer_Node() {
        Assert.assertNotNull(Q1.getNode());
    }

    @Test
    public void Queuer_Type() {
        Assert.assertSame(typ1, Q1.getType());
    }

    @Test
    public void Queuer_TypeOrdinal() {
        Assert.assertEquals(ord1, Q1.getPriorityIndex());
    }
}