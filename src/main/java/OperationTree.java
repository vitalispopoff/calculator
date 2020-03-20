import static java.lang.Double.NaN;

public class OperationTree {

    static OperationTree
            head = null;
    OperationTree
            operand$1 = null,
            operand$2 = null;
    double result = NaN;

    OperationTree() {
        if (isEmpty()) head = this;
    }

    OperationTree(OperationTree op_1, OperationTree op_2) {
        if (head == null || head == op_1 || head == op_2) head = this;
        operand$1 = op_1;
        operand$2 = op_2;
    }

    static boolean isEmpty() {
        return head == null;
    }
}