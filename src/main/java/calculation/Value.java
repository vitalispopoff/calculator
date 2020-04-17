package calculation;

public class Value extends Node {

    Value(NodeType type) {
        super(type);
    }
    @Override
    protected Double calculate(Nodeable left, Nodeable rite) {
        return value;
    }
}