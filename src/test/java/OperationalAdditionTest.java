import org.junit.*;

@Ignore
public class OperationalAdditionTest {

    @Test
    public void OperationalAddition_01(){
        OperationTree.head = null;
        OperationTree
                opT02 = new OperationTree(1.),
                opT01 = new OperationTree(-1.),
                opT00 = new OperationTree(opT01, opT02);
        Operational
                op$00 = new OperationalAddition(opT00);
        Assert.assertEquals(0., opT00.operation.operate(),0.);
        Assert.assertEquals(0., OperationTree.head.value,0.);
    }

    @Test
    public void OperationalAddition_02(){
        OperationTree.head = null;
        OperationTree
                opT04 = new OperationTree(1.),
                opT03 = new OperationTree(-2.),
                opT02 = new OperationTree(1.),
                opT01 = new OperationTree(opT03, opT04),
                opT00 = new OperationTree(opT01, opT02);
        Operational
                op$01 = new OperationalAddition(opT01),
                op$00 = new OperationalAddition(opT00);
        Assert.assertEquals(0., opT00.operation.operate(),0.);
        Assert.assertEquals(0., OperationTree.head.value,0.);
    }
}
