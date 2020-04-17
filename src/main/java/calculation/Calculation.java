package calculation;

import static java.lang.Double.NaN;

public abstract class Calculation extends Node {

    public Calculation(NodeType type) {
        super(type);
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