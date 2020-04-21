package calculation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TypicalTest {

    static Typical
            type;

    @Before
    public void setup_01(){
        type = NodeType.VALUE;
    }

    @Test
    public void getTypicalPriority_01() {

        for (Typical type : NodeType.values()) {
            Assert.assertEquals(type.ordinal()/*>>1*/, Typical.getTypicalPriority(type));
        }
    }

    @Test
    public void valueOf_01() {
        Assert.assertEquals(type, Typical.valueOf(type));
    }

    @Test
    public void ordinal_01(){
        int result = ((NodeType)type).ordinal();
        Assert.assertEquals(result, type.ordinal());
    }
}