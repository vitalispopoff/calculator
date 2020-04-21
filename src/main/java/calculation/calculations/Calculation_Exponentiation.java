package calculation.calculations;

import calculation.*;

public class Calculation_Exponentiation extends Calculation {

    public Calculation_Exponentiation(Typical type) {
        super(type);
    }

    @Override
    protected double perform(double left, double rite) {
        return Math.pow(left, rite);
    }
}