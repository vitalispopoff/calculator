package calculation;

import org.junit.*;

public class ValueTest {

    Typical type = NodeType.VALUE;
    static Value val;

    @Before
    public void initial(){
        val = (Value)type.interact();
    }

    @After
    public void terminal(){
        val = null;
    }

    @Test
    public void value_localLeft(){
        initial();
        Assert.assertNull(val.localLeft);
    }

    @Test
    public void value_localRoot(){
        initial();
        Assert.assertNull(val.localRoot);
    }

    @Test
    public void value_localRite(){
        initial();
        Assert.assertNull(val.localLeft);
    }

    @Test
    public void Value_type_01(){
        initial();
        Assert.assertEquals(type, val.type);
    }

    @Test
    public void Value_value(){
        initial();
        Double expectation = val.value;
        Assert.assertTrue(expectation.isNaN());
    }
}