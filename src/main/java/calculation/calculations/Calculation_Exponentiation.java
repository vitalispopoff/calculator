package calculation.calculations;

import calculation.*;
import gui.Button;

public class Calculation_Exponentiation extends Calculation {

    public Calculation_Exponentiation(Typical type) {
        super(type);
    }
    public Calculation_Exponentiation(Button button){super(button);}

    @Override
    protected double perform(double leftValue, double riteValue) {
        return Math.pow(leftValue, riteValue);
    }
}