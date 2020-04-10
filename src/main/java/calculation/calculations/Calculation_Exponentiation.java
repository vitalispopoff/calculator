package calculation.calculations;

import calculation.Calculation;
import calculation.Node;

public class Calculation_Exponentiation extends Calculation {


    public Calculation_Exponentiation(){super();}

/*    Calculation_Exponentiation(Node left, Node rite) {
        super(left, rite);
    }*/     // TODO disposable

    @Override
    public double calculate(double left, double rite) {
        return Math.pow(left, rite);
    }
}
