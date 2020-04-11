package calculation.calculations;

import calculation.Calculation;

public class Calculation_Exponentiation extends Calculation {

    public Calculation_Exponentiation(){super();}

    @Override
    public double calculate(double left, double rite) {
        return Math.pow(left, rite);
    }
}
