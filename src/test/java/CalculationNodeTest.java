import org.junit.*;

public class CalculationNodeTest {

    @Test   //  constructor : root assignment
    public void CalculationNode_1() {
        CalculationTree.root = null;
        CalculationTree
                node00 = new CalculationNode();
        Assert.assertSame(node00, CalculationNode.root);
    }

    @Test   // constructor : value assignment
    public void CalculationNode_2() {
        CalculationTree.root = null;
        CalculationTree
                node00 = new CalculationNode(1.);
        Assert.assertSame(node00, CalculationNode.root);
        Assert.assertEquals(1., node00.value, 0.);
    }

    @Test
    public void getValue_1() {
        CalculationTree.root = null;
        CalculationNode
                node00 = new CalculationNode(1.);
        Assert.assertEquals(1., node00.getValue(), 0.);
    }


}
