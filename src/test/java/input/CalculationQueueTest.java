package input;

import org.junit.*;

import calculation.*;

public class CalculationQueueTest {

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
        Q1 = new CalculationQueue(queuer);
    }

    @Test
    public void CalculationQueue_01(){
        Assert.assertEquals(1, ((CalculationQueue)Q1).length);
    }

    @Test
    public void CalculationQueue_02(){
        Assert.assertNotNull(((CalculationQueue)Q1).queuerNodeTypes);
    }
}