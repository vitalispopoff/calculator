package calculation;

public class Value extends Node {

    public Value(Typical type) {
        super(type);
    }

    @Override
    protected Double calculate(Nodeable localLeft, Nodeable localRite) {
        return value;
    }
}
