package input;

import org.junit.*;

import calculation.*;

public class CalculationQueueTest {

//    @Ignore
    @Test
    public void CalculationQueue_01() {
        Queueable
                q1 = new Queuer(new Value(NodeType.VALUE)),
                Q1 = new CalculationQueue(q1);
        Assert.assertTrue(((CalculationQueue) Q1).queuerNodeTypes.length > 0);
        Assert.assertSame(q1, ((CalculationQueue) Q1).prevOne);
        Assert.assertSame(q1, ((CalculationQueue) Q1).postOne);
    }

//    @Ignore
    @Test
    public void CalculationQueue_02() {
        Queueable
                q1 = new Queuer(),
                Q1 = new CalculationQueue(q1);
        Assert.assertTrue(((CalculationQueue) Q1).queuerNodeTypes.length > 0);
    }
}