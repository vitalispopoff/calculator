import org.junit.*;

import static java.lang.Double.NaN;

public class AdditionTest {

    @Test
    public void OperationalAddition_01(){
        OperationTree.head = null;
        OperationTree
                opT00 = new OperationTree();
        Operational
                op$00 = new OperationalAddition(opT00);

        Assert.assertSame(op$00, OperationTree.head.calculation);
        Assert.assertEquals(NaN, op$00.value, 0.);
    }
}
