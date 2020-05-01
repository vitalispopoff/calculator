package calculation.calculations;

import calculation.*;

public class Calculation_Division extends Calculation {

    public  Calculation_Division(){super();}

    public Calculation_Division(Typical type) {
        super(type);
    }

    @Override
    protected double perform(double leftValue, double riteValue) {
        return leftValue / riteValue;
    }
}