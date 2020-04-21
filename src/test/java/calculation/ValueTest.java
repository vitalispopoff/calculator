package calculation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class ValueTest {

    @Test
    public void value_localLeft(){
        Value value = new Value(NodeType.VALUE);
        Assert.assertNull(value.localLeft);
    }

    @Test
    public void value_localRoot(){
        Value value = new Value(NodeType.VALUE);
        Assert.assertNull(value.localRoot);
    }

    @Test
    public void value_localRite(){
        Value value = new Value(NodeType.VALUE);
        Assert.assertNull(value.localLeft);
    }

    @Test
    public void Value_type_01(){
        Typical type = NodeType.VALUE;
        Value value = new Value(type);

        Assert.assertEquals(type, value.type);
    }

    @Test
    public void Value_value(){
        Value value = new Value(NodeType.VALUE);
        Double val = value.value;

        Assert.assertTrue(val.isNaN());
    }
}