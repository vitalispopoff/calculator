package _temp;

import calculation.CalculationNode;
import calculation.CalculationValue;
import org.junit.*;

public class _CalculationValueTest {

    @Test   //  constructor : root assignment
    public void CalculationNode_1() {
        CalculationNode.root = null;
        CalculationNode
                node00 = new CalculationValue();
        Assert.assertSame(node00, CalculationValue.root);
    }

    @Test   // constructor : value assignment
    public void CalculationNode_2() {
        CalculationNode.root = null;
        CalculationNode
                node00 = new CalculationValue(1.);
        Assert.assertSame(node00, CalculationValue.root);
        Assert.assertEquals(1., node00.value, 0.);
    }

    @Test
    public void getValue_1() {
        CalculationNode.root = null;
        CalculationValue
                node00 = new CalculationValue(1.);
        Assert.assertEquals(1., node00.getValue(), 0.);
    }
}
