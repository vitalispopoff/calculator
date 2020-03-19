public class OperationalExponentiation extends Operational {

    OperationalExponentiation(OperationTree mother) {
        super(mother);
        this.mother = mother;
        mother.setOperation(this);
    }

    @Override
    void operate() {
        if (mother.isOperationable())
            mother.value = Math.pow(mother.operand$1.value, mother.operand$2.value);
    }

    public static void main(String[] args) { }
}
