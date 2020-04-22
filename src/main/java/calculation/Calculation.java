package calculation;

public abstract class Calculation extends Node {

    public Calculation(Typical type) {
        super(type);
    }

    @Override
    protected Double calculate(Nodeable localLeft, Nodeable localRite) {
        double
                leftValue = localLeft.getValue(),
                ritetValue = localRite.getValue();
        return perform(leftValue, ritetValue);
    }

    protected abstract double perform(double leftValue, double riteValue);
}