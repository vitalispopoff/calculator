package calculation;

import org.junit.Assert;
import org.junit.Test;

public class TypicalTest {

    @Test
    public void getTypePriority_01(){

        for (NodeType type: NodeType.values()) {
            Assert.assertEquals(type.ordinal()/*>>1*/, Typical.getTypicalPriority(type));
        }
    }
}