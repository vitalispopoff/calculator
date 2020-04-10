package calculation.calculations;

import calculation.Calculation;
import calculation.Node;

public class Calculation_Rooting extends Calculation {

    public Calculation_Rooting(){super();}

/*    Calculation_Rooting(Node left, Node rite) {
        super(left, rite);
    }*/     // TODO disposable

    @Override
    public double calculate(double left, double rite) {
        return Math.pow(left, 1./rite);
    }
}
