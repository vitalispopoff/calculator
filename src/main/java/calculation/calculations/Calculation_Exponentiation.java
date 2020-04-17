package calculation.calculations;

import calculation.Calculation;

public class Calculation_Exponentiation extends Calculation {

    public Calculation_Exponentiation(){
        super();
        System.out.println("exponnent");
    }

    public double calculate(double left, double rite) {
        return Math.pow(left, rite);
    }
}