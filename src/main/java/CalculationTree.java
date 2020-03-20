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

    double setValue() {
        return value;
    }

    static boolean isEmpty() {
        return root == null;
    }
}