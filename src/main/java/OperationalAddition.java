public class OperationalAddition extends Operational {

    OperationalAddition(OperationTree mother) {
        super(mother);
        this.mother = mother;
        mother.setOperation(this);
    }

    @Override
    void operate() {
    }

}
