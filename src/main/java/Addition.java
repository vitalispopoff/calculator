import static sun.misc.DoubleConsts.NaN;

public class Addition extends Operational {

    Addition(OperationTree mother) {
        super(mother);
        this.mother = mother;
        mother.setOperation(this);
    }

    @Override
    void operate() {
        if (mother.isOperationable())
            mother.value = mother.operand$1.value + mother.operand$2.value;
    }

    public static void main(String[] args) { }
}
