public class OperationTree {

    static OperationTree
            head = null;
    OperationTree
            operand$1 = null,
            operand$2 = null;
    Operation operation = null;
    double value = Double.NaN;

    static boolean isEmpty() {
        return head == null;
    }

    OperationTree() {
        if (isEmpty()) head = this;
    }

    OperationTree(OperationTree op_1, OperationTree op_2){
        if(head==null || head == op_1 || head == op_2) head = this;
        operand$1 = op_1;
        operand$2 = op_2;
    }

    OperationTree(OperationTree op){
        if(head == null || head == op) head = this;
        if(operand$1==null)operand$1 = op;
    }

    OperationTree(Operation op){
        super();
        operation = op;
    }

    public static void main(String[] args) {
        OperationTree test = new OperationTree(new OperationTree(),new OperationTree());
        System.out.println(head.equals(test));
        System.out.println();
    }

}