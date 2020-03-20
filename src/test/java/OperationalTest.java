import static java.lang.Double.NaN;
import org.junit.*;

public class OperationalTest {

    @Test   //  Operational() w/ mother != null
    public void Operational_01(){
        OperationTree.head = null;
        OperationTree
                opT00 = new OperationTree();
        Assert.assertNull(OperationTree.head.calculation);

        Operational
                op$00 = new Operational(opT00);
        Assert.assertEquals(NaN, OperationTree.head.calculation.value, 0.);
    }

    @Test   //  Operational() w/ value !=NaN
    public void Operational_02(){
        OperationTree.head = null;
        Operational
                op$00 = new Operational(1.);
        OperationTree
                opT00 = new OperationTree(op$00);

        Assert.assertSame(op$00, OperationTree.head.calculation);
        Assert.assertNull(op$00.mother);
    }

}
