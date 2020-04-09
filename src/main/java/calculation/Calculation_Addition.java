package calculation;

import static java.lang.Double.NaN;

public class Calculation_Addition extends Calculation {

    Calculation_Addition(Node left, Node rite) {
        super(left, rite);
    }

    @Override
    public /*static*/ double calculate(double left, double rite){
        return left + rite;
    }
}
