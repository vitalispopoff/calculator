import static java.lang.Double.NaN;

public class OperationTree {

    static OperationTree
            head = null;
    OperationTree
            operand$1 = null,
            operand$2 = null;
    Operational operation = null;
    double value = NaN;

    static boolean isEmpty() {
        return head == null;
    }

    OperationTree() {
        if (isEmpty()) head = this;
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

    OperationTree(double value){
        this();
        this.value = value;
    }

    boolean isOperationable() {
        return !(operand$1 == null || operand$2 == null);
    }

    void setOperation(Operational op){
        this.operation = op;
    }

    public static void main(String[] args) {
        OperationTree test = new OperationTree(new OperationTree(), new OperationTree());
        System.out.println(head.equals(test));
        System.out.println();
    }
}