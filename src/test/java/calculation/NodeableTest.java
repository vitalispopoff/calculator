package calculation;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class NodeableTest {

    @Ignore
    @Test
    public void getTypePriority_01(){
        for(NodeType type : NodeType.values()) {
            Nodeable node = new Value(type);
            Assert.assertEquals(type.ordinal()>>1, ((Node)node).type.getPriority());
        }
    }
}