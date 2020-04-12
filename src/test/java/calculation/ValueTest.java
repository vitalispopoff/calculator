package calculation;

import org.junit.*;

public class ValueTest {

    @Test
    public void type_01() {
        Node val = new Value();
        Assert.assertEquals(NodeType.VAL, val.type);
    }

    @Test
    public void Value_01() {
        Node val = new Value();
        Assert.assertNotNull(val);
    }

    @Test
    public void Value_02() {
        Node val = new Value(0.);
        Assert.assertNotNull(val);
        Assert.assertEquals(0., val.value, 0.);
    }

    @Test
    public void Value_03() {
        Node val = new Value(.0);
        Assert.assertNotNull(val);
        Assert.assertEquals(0., val.value, 0.);
        Assert.assertFalse(((Double) val.value).isNaN());
    }

    @Test
    public void setValue_01() {
        Node val = new Value();
        val.setValue(0.);
        Assert.assertEquals(0., val.value, 0.);
    }
}