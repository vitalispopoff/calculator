import static java.lang.Double.NaN;

public class OperationTree {

    static OperationTree
            head = null;
    OperationTree
            operand$1 = null,
            operand$2 = null;
    Operational operation = null;
    double value = NaN;

    OperationTree() {
        if (isEmpty()) head = this;
    }

    OperationTree(OperationTree op_1, OperationTree op_2, double val) {
        if (head == null || head == op_1 || head == op_2) head = this;
        operand$1 = op_1;
        operand$2 = op_2;
        value = val;
    }

    OperationTree(OperationTree op_1, OperationTree op_2) {
        if (head == null || head == op_1 || head == op_2) head = this;
        operand$1 = op_1;
        operand$2 = op_2;
    }

    OperationTree(OperationTree op) {
        if (head == null || head == op) head = this;
        if (operand$1 == null) operand$1 = op;
    }

    OperationTree(Operational op) {
        this();
        this.operation = op;
        op.mother = this;
    }

    OperationTree(double value) {
        this();
        this.value = value;
    }

    void setOperation(Operational op) {
        this.operation = op;
    }

    void setValue(double val) {
        this.value = val;
    }

    static boolean isEmpty() {
        return head == null;
    }

    boolean isOperationable() {
        return !(operand$1 == null || operand$2 == null);
    }

    double operate() {
        double result = NaN;
        return result;
    }

    public static void main(String[] args) {
        OperationTree
                opT_5 = new OperationTree(0.),
                opT_4 = new OperationTree(-1.),
                opT_3 = new OperationTree(1.),
                opT_2 = new OperationTree(opT_4, opT_5),
                opT_1 = new OperationTree(opT_2, opT_3);
        Operational
                op_2 = new OperationalAddition(opT_2),
                op_1 = new OperationalAddition(opT_1);
    }
}