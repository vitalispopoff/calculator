package calculation.calculations;

import calculation.*;

public class Calculation_Division extends Calculation {

    public Calculation_Division(Typical type) {
        super(type);
    }

    @Override
    protected double perform(double left, double rite) {
        return left / rite;
    }
}