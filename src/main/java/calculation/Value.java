package calculation;

public class Value extends Node {

    public Value(Typical type) {
        super(type);
    }

    /**
     * <!--
     * !SSUE#4 : connect GUI with input
     * -->
     * <p><a href="https://github.com/vitalispopoff/calculator/issues/4">Issue #4</a> : Connect GUI with input package</p>
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