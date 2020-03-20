import static java.lang.Double.NaN;

public class Operational {

    OperationTree mother = null;
    double value = NaN;

    Operational(OperationTree mother){
        this.mother = mother;
        this.mother.setCalculation(this);
    }

    Operational(double value){
        this.value = value;
    }

    void operate(){}
}