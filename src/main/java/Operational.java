import static java.lang.Double.NaN;

public class Operational {

    OperationTree mother = null;
    double value = NaN;

    Operational(OperationTree mother){
        this.mother = mother;
    }
    void operate(){}
}