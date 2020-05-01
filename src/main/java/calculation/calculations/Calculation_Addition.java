package calculation.calculations;

import calculation.*;

public class Calculation_Addition extends Calculation {

    public Calculation_Addition(){super();}

    public Calculation_Addition(Typical type) {
        super(type);
    }

    @Override
    protected double perform(double leftValue, double riteValue) {
        return leftValue + riteValue;
    }
}