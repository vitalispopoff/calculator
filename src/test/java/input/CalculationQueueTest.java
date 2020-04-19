package input;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class CalculationQueueTest {

    @Test
    public void CalculationQueue_01() {
        Queueable
                q1 = new Queuer(),
                Q1 = new CalculationQueue(q1);
        Assert.assertTrue(((CalculationQueue) Q1).queuerNodeTypes.length > 0);
        Assert.assertSame(q1, ((CalculationQueue) Q1).prevOne);
        Assert.assertSame(q1, ((CalculationQueue) Q1).postOne);
    }

    @Test
    public void CalculationQueue_02() {
        Queueable
                q1 = new Queuer(),
                Q1 = new CalculationQueue(q1);
        Assert.assertTrue(((CalculationQueue) Q1).queuerNodeTypes.length > 0);
    }

    @Ignore
    @Test   // ? disposable - method used in the constructor
    public void setQueuerNodeTypes_01() {
        Queueable Q1 = new CalculationQueue(new Queuer());
        ((CalculationQueue) Q1).setQueuerNodeTypes();
        Assert.assertTrue(((CalculationQueue) Q1).queuerNodeTypes.length > 0);
    }


}