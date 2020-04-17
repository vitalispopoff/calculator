package calculation.calculations;

import calculation.Calculation;

public class Calculation_Subtraction extends Calculation {

    public Calculation_Subtraction(){
        super();
        System.out.println("divide");
    }

    public double calculate(double left, double rite) {
        return left - rite;
    }
}