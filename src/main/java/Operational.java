import static java.lang.Double.NaN;

public class Operational {

    OperationTree mother = null;

    Operational(OperationTree mother){
        this.mother = mother;
    }

    double operate(){
        return NaN;
    }

    static double operate(OperationTree op_1, OperationTree op_2){
        return NaN;
    }
}