package calculation.otherExpressions;

import calculation.NodeType;
import calculation.Typical;
import calculation.otherExpressions.Value;
import org.junit.*;


public class ValueTest {

    static Typical
            type = NodeType.VALUE;
    static Value
            val;

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Before
    public void initial() {
        val = new Value(type);
    }

    @After
    public void terminal() {
        val = null;
    }

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Test
    public void value_localLeft() {
        initial();
        Assert.assertNull(val.getLocalLeft());
    }

    @Test
    public void value_localRoot() {
        initial();
        Assert.assertNull(val.getLocalRoot());
    }

    @Test
    public void value_localRite() {
        initial();
        Assert.assertNull(val.getLocalRite());
    }

    @Test
    public void Value_type_01() {
        initial();
        Assert.assertEquals(type, val.getType());
    }

    @Test
    public void Value_value() {
        initial();
        Double expectation = val.getValue();
        Assert.assertTrue(expectation.isNaN());
    }
}