package calculation.calculations;

import calculation.Calculation;
import calculation.Node;

public class Calculation_Addition extends Calculation {

    public Calculation_Addition(){super();}

    /*Calculation_Addition(Node left, Node rite) {
        super(left, rite);
    }*/ // TODO disposable

    @Override
    public double calculate(double left, double rite) {
        return left + rite;
    }
}
