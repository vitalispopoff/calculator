import static java.lang.Double.NaN;

public abstract class CalculationTree {

    static CalculationTree
            root = null;
    CalculationTree
            op_1 = null,
            op_2 = null;
    double value = NaN;

    CalculationTree() {
        if (isEmpty()) root = this;
    }

    CalculationTree(CalculationTree op_1, CalculationTree op_2) {
        if (root == null || root == op_1 || root == op_2) root = this;
        this.op_1 = op_1;
        this.op_2 = op_2;
    }

    CalculationTree(double value) {
        this();
        this.value = value;
    }

    double getValue() {
        return value;
    }

    void setValue(double value) {
        this.value = value;
    }

    double operate(double op_1Value, double op_2Value){
        return NaN;
    }

    double setValue() {
        boolean
                isNaN = ((Double) this.value).isNaN(),
                op_1IsNaN = ((Double) op_1.value).isNaN(),
                op_2IsNaN = ((Double) op_2.value).isNaN();
        double
                op_1Value = op_1IsNaN ? op_1.setValue() : this.op_1.value,
                op_2Value = op_2IsNaN ? op_2.setValue() : this.op_2.value,
                result = isNaN ? operate(op_1Value, op_2Value) : this.value;
        this.setValue(result);
        return result;
    }

    static boolean isEmpty() {
        return root == null;
    }
}