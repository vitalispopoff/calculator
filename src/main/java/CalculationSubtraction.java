public class CalculationSubtraction extends CalculationTree {

    CalculationSubtraction(CalculationTree op_1, CalculationTree op_2) {
        super(op_1, op_2);
    }

    @Override
    double operate(double op_1Val1, double op_2Val2) {
        return op_1Val1 - op_2Val2;
    }
}
