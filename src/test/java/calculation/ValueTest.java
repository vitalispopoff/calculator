package calculation;

import org.junit.*;

public class ValueTest {

    @Ignore
    @Test
    public void type_01(){
        Node val = new Value();
        Assert.assertEquals(NodeType.OPERAND, val.type);
    }

    @Test       //  * empty constructor
    public void Value_01() {
        Node val = new Value();
        Assert.assertNotNull(val);
    }

    @Test       //  * constructor w/ value
    public void Value_02() {
        Node val = new Value(0.);
        Assert.assertNotNull(val);
        Assert.assertEquals(0., val.value, 0.);
    }

    @Test       //  * constructor w/ value
    public void Value_03() {
        Node val = new Value(.0);
        Assert.assertNotNull(val);
        Assert.assertEquals(0., val.value, 0.);
        Assert.assertFalse(((Double) val.value).isNaN());
    }

    @Test       //  * constructor w/ branches
    public void Value_04() {
        Node
                left = new Value(),
                rite = new Value(),
                val = new Value(left, rite);
        Assert.assertNull(val.localLeft);
        Assert.assertNull(val.localRite);
        Assert.assertTrue(((Double) val.value).isNaN());
    }

    @Test
    public void setValue_01(){
        Node
                val = new Value();
        val.setValue(0.);
        Assert.assertEquals(0., val.value, 0.);
    }
}