package calculation;

import org.junit.Assert;
import org.junit.Test;

public class NodeableTest {

    @Test
    public void getTypePriority_01(){
        for(NodeType type : NodeType.values()) {
            Nodeable node = new Value(type);
            Assert.assertEquals(type.ordinal()>>1, node.getPriority());
        }
    }
}