import org.junit.*;

public class CalculationAdditionTest {

    @Test   //  constructor
    public void CalculationAddition_1() {
        CalculationNode.root = null;
        CalculationNode
                node02 = new CalculationValue(1.),
                node01 = new CalculationValue(1.),
                node00 = new CalculationAddition(node01, node02);
        Assert.assertSame(node01, node00.op_1);
        Assert.assertSame(node02, node00.op_2);
    }

    @Test   // single addition
    public void setValue_1() {
        CalculationNode.root = null;
        CalculationNode
                node02 = new CalculationValue(1.),
                node01 = new CalculationValue(1.),
                node00 = new CalculationAddition(node01, node02);
        node00.setValue();
        Assert.assertEquals(node01.value + node02.value, node00.value,0.);
    }

    @Test   // recursive addition
    public void setValue_2(){
        CalculationNode.root = null;
        CalculationNode
                node04 = new CalculationValue(1.),
                node03 = new CalculationValue(1.),
                node02 = new CalculationAddition(node03, node04),
                node01 = new CalculationValue(1.),
                node00 = new CalculationAddition(node01, node02);
        Assert.assertEquals(
                node01.value + node03.value + node04.value,
                node00.setValue(),
                0.);
    }

}
