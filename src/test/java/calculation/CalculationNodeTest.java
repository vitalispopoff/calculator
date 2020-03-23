package calculation;

import org.junit.*;

public class CalculationNodeTest {

    @Test
    public void getValue_1() {
        CalculationNode.root = null;
        CalculationNode
                node00 = new CalculationValue(1.);
        Assert.assertEquals(1., node00.getValue(), 0.);
    }

    @Test
    public void recursive_setValue_1() {
        CalculationNode.root = null;
        CalculationNode
                node06 = new CalculationValue(1.),
                node05 = new CalculationValue(2.),
                node04 = new CalculationValue(1.),
                node03 = new CalculationValue(1.),
                node02 = new CalculationSubtraction(node05, node06),
                node01 = new CalculationAddition(node03, node04),
                node00 = new CalculationAddition(node01, node02);
        Assert.assertEquals(
                node03.value + node04.value + node05.value - node06.value,
                node00.setValue(),
                0.);
    }
}
