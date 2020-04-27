package calculation;

public class Value extends Node {

    public Value(Typical type) {
        super(type);
    }

    /**
     * // TODO #4 : <a href="https://github.com/vitalispopoff/calculator/issues/4">Connect GUI with input pacakge</a>
     * */
    @Override
    public void setValue() {
        super.setValue();
    }

    @Override
    protected Double calculate(Nodeable localLeft, Nodeable localRite) {
        return value;
    }
}
