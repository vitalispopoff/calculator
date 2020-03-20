public class CalculationSubtraction extends CalculationTree {

    CalculationSubtraction(CalculationTree op_1, CalculationTree op_2) {
        super(op_1, op_2);
    }

    @Override
    double setValue() {
        boolean
                isNaN = ((Double) this.value).isNaN(),
                op_1IsNaN = ((Double) op_1.value).isNaN(),
                op_2IsNaN = ((Double) op_2.value).isNaN();
        double
                op_1Value = op_1IsNaN ? op_1.setValue() : this.op_1.value,
                op_2Value = op_2IsNaN ? op_2.setValue() : this.op_2.value,
                result = isNaN ? op_1Value - op_2Value : this.value;
        this.setValue(result);
        return result;
    }
}
