package calculation;

public class CalculationSubtraction extends CalculationNode {

    CalculationSubtraction(CalculationNode op_1, CalculationNode op_2) {
        super(op_1, op_2);
    }

    @Override
    public double operate(double op_1Val1, double op_2Val2) {
        return op_1Val1 - op_2Val2;
    }
}
