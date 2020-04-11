package calculation.calculations;

import calculation.Calculation;

public class Calculation_Division extends Calculation {

    public Calculation_Division(){super();}

    @Override
    public double calculate(double left, double rite) {
        return left / rite;
    }
}
