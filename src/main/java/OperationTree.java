public class OperationTree {

    static OperationTree
            head = null;
    OperationTree
            operand$1 = null,
            operand$2 = null;
    Operational calculation = null;

    OperationTree() {
        if (isEmpty()) head = this;
    }

    OperationTree(OperationTree op_1, OperationTree op_2) {
        if (head == null || head == op_1 || head == op_2) head = this;
        operand$1 = op_1;
        operand$2 = op_2;
    }

    OperationTree(Operational calculation){
        this();
        this.calculation = calculation;
    }


    void setCalculation(Operational calculation){
        this.calculation = calculation;
    }

    static boolean isEmpty() {
        return head == null;
    }
}