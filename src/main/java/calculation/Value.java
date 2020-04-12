package calculation;

public class Value extends Node {

    static final NodeType classType = NodeType.VAL;

    public Value(double value) {
        super(value);
    }

    public Value() {
        super();
    }

    @Override
    public void setType() {
        this.type = classType;
    }
}