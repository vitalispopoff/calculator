import org.junit.*;

public class OperationTreeTest {

    @Test   //  OperationTree()
    public void OperationTree_01() {
        OperationTree.head = null;
        Assert.assertNull(OperationTree.head);
        OperationTree test = new OperationTree();
        Assert.assertSame(test, OperationTree.head);
    }

    @Test   //  OperationTree(new OperationTree(), new OperationTree())
    public void OperationTree_02() {
        OperationTree.head = null;
        Assert.assertNull(OperationTree.head);
        OperationTree
                test = new OperationTree(new OperationTree(), new OperationTree());
        Assert.assertSame(test, OperationTree.head);
    }

    @Test   //  OperationTree(op_1, op_2)
    public void OperationTree_03() {
        OperationTree.head = null;
        OperationTree
                operand_1 = new OperationTree(),
                operand_2 = new OperationTree(),
                test = new OperationTree(operand_1, operand_2);
        Assert.assertSame(test, OperationTree.head);
    }

    @Test   //  OperationTree(null, op_2)
    public void OperationTree_04() {
        OperationTree.head = null;
        OperationTree
                operand_2 = new OperationTree(),
                test = new OperationTree(null, operand_2);
        Assert.assertSame(test, OperationTree.head);
    }
}