package calculation;

public class Calculation_Addition extends Calculation {

    Calculation_Addition(Node left, Node rite) {
        super(left, rite);
    }

    @Override
    public double calculate(double left, double rite) {
        return left + rite;
    }
}
