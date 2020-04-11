package calculation.calculations;

import calculation.Calculation;

public class Calculation_Multiplication extends Calculation {

    public Calculation_Multiplication(){
        super();
    }

    @Override
    public double calculate(double left, double rite) {
        return left * rite;
    }
}
