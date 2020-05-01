package calculation.calculations;

import calculation.*;

public class Calculation_Rooting extends Calculation {

    public Calculation_Rooting(){super();}

    public Calculation_Rooting(Typical type) {
        super(type);
    }

    @Override
    protected double perform(double leftValue, double riteValue) {
        return Math.pow(leftValue, 1. / riteValue);
    }
}