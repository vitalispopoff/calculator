package calculation.calculations;

import calculation.Node;
import calculation.NodeType;
import org.junit.Assert;
import org.junit.Test;

public class Calculation_AdditionTest {

    @Test
    public void Calculation_addition_01() {
        Node n = new Calculation_Addition();
        Assert.assertTrue(n instanceof Calculation_Addition);
    }

    @Test
    public void getType_01() {
        Node result = new Calculation_Addition();
        Assert.assertSame(NodeType.ADD_SUB, result.getType());
    }
}