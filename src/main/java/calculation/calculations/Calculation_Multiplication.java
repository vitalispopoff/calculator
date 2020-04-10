package calculation.calculations;

import calculation.Calculation;
import calculation.Node;

public class Calculation_Multiplication extends Calculation {

    public Calculation_Multiplication(){
        super();
    }

/*    public Calculation_Multiplication(Node left, Node rite) {
        super(left, rite);
    }*/ // TODO disposable

    @Override
    public double calculate(double left, double rite) {
        return left * rite;
    }
}
