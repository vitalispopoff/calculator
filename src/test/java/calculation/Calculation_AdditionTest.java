package calculation;

import calculation.calculations.Calculation_Addition;
import org.junit.Assert;
import org.junit.Test;

public class Calculation_AdditionTest {

    @Test
    public void type_01() {
        Node result = new Calculation_Addition(new Value(), new Value());
        Assert.assertSame(NodeType.OPERATOR, result.type);
    }
}
