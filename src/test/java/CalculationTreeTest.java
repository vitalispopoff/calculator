import org.junit.*;

public class CalculationTreeTest {

    @Test
    public void getValue_1() {
        CalculationTree.root = null;
        CalculationTree
                node00 = new CalculationNode(1.);
        Assert.assertEquals(1., node00.getValue(), 0.);
    }

    @Test
    public void recursive_setValue_1() {
        CalculationTree.root = null;
        CalculationTree
                node06 = new CalculationNode(1.),
                node05 = new CalculationNode(2.),
                node04 = new CalculationNode(1.),
                node03 = new CalculationNode(1.),
                node02 = new CalculationSubtraction(node05, node06),
                node01 = new CalculationAddition(node03, node04),
                node00 = new CalculationAddition(node01, node02);
        Assert.assertEquals(
                node03.value + node04.value + node05.value - node06.value,
                node00.setValue(),
                0.);

    }
}
