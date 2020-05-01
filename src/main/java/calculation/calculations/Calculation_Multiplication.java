package calculation.calculations;

import calculation.*;

public class Calculation_Multiplication extends Calculation {

    public Calculation_Multiplication(){super();}

    public Calculation_Multiplication(Typical type) {
        super(type);
    }

    @Override
    protected double perform(double leftValue, double riteValue) {
        return leftValue * riteValue;
    }


}