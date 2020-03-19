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

    static boolean isEmpty() {
        return head == null;
    }

    boolean isOperationable() {
        return !(operand$1 == null || operand$2 == null);
    }

    void operate() {
        if (operand$1.value == NaN) operand$1.operation.operate();
        if (operand$2.value == NaN) operand$2.operation.operate();
        operation.operate();
    }

    public static void main(String[] args) {
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

        opT_1.operate();
        System.out.println(opT_8.value);
    }
}