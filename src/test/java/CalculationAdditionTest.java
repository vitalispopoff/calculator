import org.junit.*;

public class CalculationAdditionTest {

    @Test
    public void CalculationAddition_1() {
        CalculationTree.root = null;
        CalculationTree
                node02 = new CalculationNode(1.),
                node01 = new CalculationNode(1.),
                node00 = new CalculationAddition(node01, node02);
        Assert.assertSame(node01, node00.op_1);
        Assert.assertSame(node02, node00.op_2);
    }

    @Test
    public void setValue_1() {
        CalculationTree.root = null;
        CalculationTree
                node02 = new CalculationNode(1.),
                node01 = new CalculationNode(1.),
                node00 = new CalculationAddition(node01, node02);
        node00.setValue();
        Assert.assertEquals(node01.value + node02.value, node00.value,0.);

    }

}
