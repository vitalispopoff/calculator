package calculation.calculations;

import calculation.Calculation;

public class Calculation_Rooting extends Calculation {

    public Calculation_Rooting(){super();}

    @Override
    public double calculate(double left, double rite) {
        return Math.pow(left, 1./rite);
    }
}
