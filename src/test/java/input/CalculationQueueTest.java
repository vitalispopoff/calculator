package input;

import org.junit.*;

import calculation.*;

public class CalculationQueueTest {

        @Ignore
    @Test
    public void CalculationQueue_01() {
        Queueable
                q1 = new Queuer(new Value(NodeType.VALUE)),
                Q1 = new CalculationQueue(q1);
        Assert.assertTrue(((CalculationQueue) Q1).queuerNodeTypes.length > 0);
        Assert.assertSame(q1, ((CalculationQueue) Q1).prevOne);
        Assert.assertSame(q1, ((CalculationQueue) Q1).postOne);
    }

        @Ignore
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

        @Ignore
    @Test
    public void currentPriority_01() {
        NodeType type = NodeType.VALUE;
        Nodeable n1 = (NodeType.valueOf(type.toString()).interact());
        Assert.assertEquals(type, n1.getType());
        Assert.assertTrue(n1 instanceof Node);
    }

    @Ignore
    @Test
    public void currentPriority_02() {
//        NodeType type = NodeType.VALUE;
        NodeType type = NodeType.BRACKET_IN;
        Nodeable node = (NodeType.valueOf(type.toString()).interact());
        Queueable
                q1 = new Queuer(node),
                Q1 = new CalculationQueue(q1);
        ((CalculationQueue) Q1).updatePriority(q1);
//        Assert.assertTrue(((CalculationQueue) Q1).queuerNodeTypes.length > 0);

        int x = 0;
        for (int i : ((CalculationQueue) Q1).queuerNodeTypes)
            System.out.println(x++ + " : " + i);

//        System.out.println(((CalculationQueue)Q1).currentPriority());


//        System.out.println(((CalculationQueue) Q1).currentPriority());
//        System.out.println(NodeType.BRACKET_IN.getPriority());
    }
}