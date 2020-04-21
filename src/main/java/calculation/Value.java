package calculation;

public class Value extends Node {

    public Value(Typical type) {
        super(type);
    }

    @Override
    protected Double calculate(Nodeable left, Nodeable rite) {
        return value;
    }
}
