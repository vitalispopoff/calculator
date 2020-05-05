package calculation.calculations;

import calculation.*;
import gui.Button;

public class Calculation_Division extends Calculation {

    public Calculation_Division(Typical type) {
        super(type);
    }
    public Calculation_Division(Button button){super(button);}

    @Override
    protected double perform(double leftValue, double riteValue) {
        return leftValue / riteValue;
    }
}