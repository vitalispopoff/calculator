package calculation.calculations;

import calculation.*;
import gui.Button;

public class Calculation_Subtraction extends Calculation {

    public Calculation_Subtraction(Typical type) {
        super(type);
    }
    public Calculation_Subtraction(Button button){super(button);}

    @Override
    protected double perform(double leftValue, double riteValue) {
        return leftValue - riteValue;
    }
}