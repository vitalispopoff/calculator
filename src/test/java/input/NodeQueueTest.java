package input;

import org.junit.*;

import calculation.*;

public class NodeQueueTest {

    static Typical
            type;
    static Nodeable
            node;
    static Queueable
            queuer,
            Q1;

    @Before
    public void setup_01() {
        type = NodeType.VALUE;
        node = new Value(type);
        queuer = new Queuer(node);
        Q1 = new NodeQueue(queuer);
    }

    @Test
    public void CalculationQueue_01(){
        Assert.assertEquals(1, ((NodeQueue)Q1).length);
    }

    @Test
    public void CalculationQueue_02(){
        Assert.assertNotNull(((NodeQueue)Q1).queuerNodeTypes);
    }
}