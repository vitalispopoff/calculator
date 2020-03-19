import static java.lang.Double.NaN;

public class OperationalAddition extends Operational {

    OperationalAddition(OperationTree mother) {
        super(mother);
//        this.mother = mother;
        mother.setOperation(this);
    }

    @Override
    double operate() {
        double
                parameter$1 = this.mother.operand$1.value == NaN ? this.mother.operand$1.operation.operate() : this.mother.operand$1.value,
                parameter$2 = this.mother.operand$2.value == NaN ? this.mother.operand$2.operation.operate() : this.mother.operand$2.value,
                result = this.mother.value == NaN ? parameter$1 + parameter$2 : this.mother.value;
        if (this.mother.value == NaN) this.mother.setValue(result);
        return result;
    }

    public static void main(String[] args) {
    }
}