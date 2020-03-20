import org.junit.*;

public class CalculationTreeTest {

    @Test
    public void getValue_1(){
        CalculationTree.root = null;
        CalculationTree
                node00 = new CalculationNode(1.);
        Assert.assertEquals(1., node00.getValue(), 0.);
    }
}
