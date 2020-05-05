package calculation.calculations;

import calculation.*;
import gui.Button;

public class Calculation_Addition extends Calculation {

    public Calculation_Addition(Typical type) {
        super(type);
    }
    public Calculation_Addition(Button button){super(button);}

    @Override
    protected double perform(double leftValue, double riteValue) {
        return leftValue + riteValue;
    }
}