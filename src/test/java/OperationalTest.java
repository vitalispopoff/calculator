import static java.lang.Double.NaN;
import org.junit.*;

public class OperationalTest {

    @Test
    public void OperationTree_01(){
        OperationTree.head = null;
        OperationTree
                opT00 = new OperationTree();
        Assert.assertNull(OperationTree.head.calculation);

        Operational
                op$00 = new Operational(opT00);
        Assert.assertEquals(NaN, OperationTree.head.calculation.value, 0.);

    }

}
