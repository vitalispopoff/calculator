package calculation.calculations;

import calculation.*;

public class Calculation_Exponentiation extends Calculation {

    public Calculation_Exponentiation() {
        super();
    }

    public Calculation_Exponentiation(Typical type) {
        super(type);
    }

    @Override
    protected double perform(double leftValue, double riteValue) {
        return Math.pow(leftValue, riteValue);
    }
}