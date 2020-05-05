package calculation.calculations;

import calculation.*;
import gui.Button;

public class Calculation_Rooting extends Calculation {

    public Calculation_Rooting(Typical type) {
        super(type);
    }
    public Calculation_Rooting(Button button){super(button);}

    @Override
    protected double perform(double leftValue, double riteValue) {
        return Math.pow(leftValue, 1. / riteValue);
    }
}