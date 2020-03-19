import com.sun.org.apache.xpath.internal.operations.Operation;
import org.junit.*;

public class OperationTreeTest {

    //    @Ignore
    @Test
    public void OperationTree_01() {
        OperationTree.head = null;
        Assert.assertNull(OperationTree.head);
        OperationTree test = new OperationTree();
        Assert.assertSame(test, OperationTree.head);
    }   //  OperationTree()

    @Test
    public void OperationTree_02() {
        OperationTree.head = null;
        Assert.assertNull(OperationTree.head);
        OperationTree
                test = new OperationTree(new OperationTree(), new OperationTree());
        Assert.assertSame(test, OperationTree.head);
    }   //  OperationTree(new OperationTree(), new OperationTree())

    @Test
    public void OperationTree_03() {
        OperationTree.head = null;
        OperationTree
                operand_1 = new OperationTree(),
                operand_2 = new OperationTree(),
                test = new OperationTree(operand_1, operand_2);
        Assert.assertSame(test, OperationTree.head);
    }   //  OperationTree(op_1, op_2)

    @Test
    public void OperationTree_04() {
        OperationTree.head = null;
        OperationTree
                operand_2 = new OperationTree(),
                test = new OperationTree(null, operand_2);
        Assert.assertSame(test, OperationTree.head);
    }   //  OperationTree(null, op_2)

    @Test
    public void setOperation_01() {
        OperationTree
                test = new OperationTree();
        Operational op = new Operational(test);
        test.setOperation(op);
        Assert.assertSame(op, test.operation);
    }

    @Test
    public void setOperation_02() {
        OperationTree
                test = new OperationTree();
        Operational op = new Operational(null);
        test.setOperation(op);
        Assert.assertSame(op, test.operation);
    }

    @Test
    public void isEmpty_01() {
        OperationTree.head = null;
        Assert.assertTrue(OperationTree.isEmpty());
    }

    @Test
    public void isEmpty_02() {
        OperationTree.head = null;
        OperationTree test = new OperationTree();
        Assert.assertFalse(OperationTree.isEmpty());
    }

    @Test
    public void operate_01() {
        OperationTree.head = null;

        OperationTree
                opT_B = new OperationTree(3.),
                opT_A = new OperationTree(2.),
                opT_9 = new OperationTree(4.),
                opT_8 = new OperationTree(opT_A, opT_B),
                opT_7 = new OperationTree(opT_8, opT_9),
                opT_6 = new OperationTree(1.),
                opT_5 = new OperationTree(5),
                opT_4 = new OperationTree(opT_6, opT_7),
                opT_3 = new OperationTree(6.),
                opT_2 = new OperationTree(opT_4, opT_5),
                opT_1 = new OperationTree(opT_2, opT_3);
        Operational
                op_1 = new OperationalSubtraction(opT_1),
                op_2 = new OperationalAddition(opT_2),
                op_4 = new OperationalAddition(opT_4),
                op_7 = new OperationalDivision(opT_7),
                op_8 = new OperationalMultiplication(opT_8);

        Assert.assertSame(OperationTree.head, opT_1);   //  this ai bonus: although opT_1 is last to be declared it's the root for all the tree hence should be declared head.
        opT_1.operate();
        Assert.assertEquals( 10.5,opT_1.value, 0.);
    }



}