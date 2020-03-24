package calculation;

import static java.lang.Double.NaN;

public abstract class CalculationNode /*implements calculation.CalculationTree*/ {

    public static CalculationNode
            root = null,
            head = null;
    CalculationNode
            op_1 = null,
            op_2 = null;
    double value = NaN;

    public CalculationNode() {
        if (isEmpty()) root = this;
        head = this;
    }

    CalculationNode(CalculationNode op_1, CalculationNode op_2) {
        if (root == null || root == op_1 || root == op_2) root = this;
        this.op_1 = op_1;
        this.op_2 = op_2;
    }

    CalculationNode(String string) {

    }

    CalculationNode(double value) {
        this();
        this.value = value;
    }

    double getValue() {
        return value;
    }

    double setValue(double value) {
        return this.value = value;
    }

    public double setValue() {
        double
                op_1Value = op_1.valueIsNaN() ? op_1.setValue() : this.op_1.value,
                op_2Value = op_2.valueIsNaN() ? op_2.setValue() : this.op_2.value,
                result = this.valueIsNaN() ? operate(op_1Value, op_2Value) : this.value;
        return this.setValue(result);
    }

    public double operate(double op_1Value, double op_2Value) {
        return NaN;
    }

    static boolean isEmpty() {
        return root == null;
    }

    boolean valueIsNaN() {
        return ((Double) value).isNaN();
    }

    void insertAsOperand() {
    }

    void insertAsOperator() {
    }


}