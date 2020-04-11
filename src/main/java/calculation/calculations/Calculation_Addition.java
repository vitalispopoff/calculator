package calculation.calculations;

import calculation.Calculation;

public class Calculation_Addition extends Calculation {

    public Calculation_Addition(){super();}

    @Override
    public double calculate(double left, double rite) {
        return left + rite;
    }
}
