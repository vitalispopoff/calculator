package calculation;

public abstract class Calculation extends Node {

    public Calculation(Typical type) {
        super(type);
        System.out.println("dupa");
    }

    @Override
    protected Double calculate(Nodeable left, Nodeable rite) {
        double
                leftValue = left.getValue(),
                ritetValue = rite.getValue();
        return perform(leftValue, ritetValue);
    }

    protected abstract double perform(double left, double rite);
}