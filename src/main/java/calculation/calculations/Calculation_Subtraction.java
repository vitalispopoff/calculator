package calculation.calculations;

import calculation.*;

public class Calculation_Subtraction extends Calculation {

    public Calculation_Subtraction(Typical type) {
        super(type);
    }

    @Override
    protected double perform(double leftValue, double riteValue) {
        return leftValue - riteValue;
    }
}