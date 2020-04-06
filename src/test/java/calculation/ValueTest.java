package calculation;

import org.junit.*;

public class ValueTest {

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
    }

    @Test
    public void Value_04() {
        Node
                left = new Value(),
                rite = new Value(),
                val = new Value(left, rite);
        Assert.assertNull(val.localLeft);
        Assert.assertNull(val.localRite);
        Assert.assertEquals(Double.NaN, (double)val.value);
    }

}