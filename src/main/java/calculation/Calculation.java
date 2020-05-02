package calculation;

public abstract class Calculation extends Node {

    public Calculation(){super();}

    public Calculation(Typical type) {
        super(type);
/*        Value.resetCurrent();*/
    }

    @Override
    protected Double calculate(Nodeable localLeft, Nodeable localRite) {
        double
                leftValue = localLeft.getValue(),
                riteValue = localRite.getValue();
        return perform(leftValue, riteValue);
    }

    protected abstract double perform(double leftValue, double riteValue);
}