import static java.lang.Double.*;


public class CalculationAddition extends CalculationTree {

    CalculationAddition() {
        super();
    }

    CalculationAddition(CalculationTree op_1, CalculationTree op_2) {
        super(op_1, op_2);
    }

    @Override
    void setValue() {
        Double
                op_1Value = this.op_1.value,
                op_2Value = this.op_2.value/*,
                result = ((Double) this.value).isNaN() ? sum(op_1Value, op_2Value) : this.value*/;
        this.setValue (((Double) this.value).isNaN() ? sum(op_1Value, op_2Value) : this.value);
    }
}
