package calculation.calculations;

import calculation.*;
import gui.Button;

public class Calculation_Multiplication extends Calculation {

    public Calculation_Multiplication(Typical type) {
        super(type);
    }
    public Calculation_Multiplication(Button button){super(button);}

    @Override
    protected double perform(double leftValue, double riteValue) {
        return leftValue * riteValue;
    }


}