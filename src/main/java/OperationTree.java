public class OperationTree {

    static OperationTree
            head = null;
    OperationTree
            operand$1 = null,
            operand$2 = null;
    Operationable operation = null;
    double value = Double.NaN;

    OperationTree(){
        if (head == null) head = this;
    }

    OperationTree(OperationTree operand$1, OperationTree operand$2){
        if (head == null || head == operand$1 || head == operand$2) head = this;
        this.operand$1 = operand$1;
        this.operand$1 = operand$2;
    }

    OperationTree(Operationable operation, OperationTree operand$1, OperationTree operand$2){
        this(operand$1, operand$2);
        this.operation = operation;
    }

    OperationTree(double value){
        if(head==null) head = this;
        this.value = value;
    }
}
