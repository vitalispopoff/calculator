public class OperationalAddition extends Operational {

    OperationalAddition(OperationTree mother) {
        super(mother);
        this.mother = mother;
        mother.setCalculation(this);
    }

    @Override
    void operate() {
    }

}
