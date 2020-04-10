package calculation.calculations;

import calculation.Calculation;
import calculation.Node;

public class Calculation_Subtraction extends Calculation {

    public Calculation_Subtraction(){super();}

/*Calculation_Subtraction(Node left, Node rite) {
        super(left, rite);
    }*/ // TODO dispoable

    @Override
    public double calculate(double left, double rite) {
        return left - rite;
    }
}
