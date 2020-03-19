import org.junit.*;

public class AdditionTest {

    @Test
    public void Addition_01(){
        OperationTree
                op_1 = new OperationTree(-1.),
                op_2 = new OperationTree(1.),
                test = new OperationTree(op_1, op_2);
        Operational add_ = new OperationalAddition(test);

        Assert.assertSame(test, add_.mother);
        Assert.assertSame(add_, test.operation);
    }

    @Test
    public void operate_01(){
        OperationTree.head = null;
        OperationTree
                op_1 = new OperationTree(-1.),
                op_2 = new OperationTree(1.),
                test = new OperationTree(op_1, op_2);
        Operational add_ = new OperationalAddition(test);
        add_.operate();
        Assert.assertEquals(test.value,0.,0);
        Assert.assertEquals(OperationTree.head.value,0.,0);
        Assert.assertEquals(add_.mother.value, 0., 0);
    }
}
