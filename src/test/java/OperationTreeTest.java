import org.junit.*;

public class OperationTreeTest {

    @Test
    public void OperationTree_01() {
        Assert.assertNull(OperationTree.head);
        OperationTree test = new OperationTree();
        Assert.assertSame(test, OperationTree.head);
    }

    @Test
    public void OperationTree_02() {
        OperationTree.head = null;
        Assert.assertNull(OperationTree.head);
        OperationTree test = new OperationTree(new OperationTree(), new OperationTree());
        Assert.assertSame(test, OperationTree.head);
    }

    @Test
    public void OperationTree_03() {
        OperationTree.head = null;
        OperationTree
                operand_1 = new OperationTree(),
                operand_2 = new OperationTree(),
                test = new OperationTree(operand_1, operand_2);
        Assert.assertSame(test, OperationTree.head);
    }

    @Test
    public void OperationTree_04() {
        OperationTree.head = null;
        OperationTree
                operand_2 = new OperationTree(),
                test = new OperationTree(null, operand_2);
        Assert.assertSame(test, OperationTree.head);
    }

}