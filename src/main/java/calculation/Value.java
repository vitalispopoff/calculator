package calculation;

public class Value extends Node {

    static final NodeType classType = NodeType.OPERAND;

    Value(double value) {
        super(value);
    }

    Value() {
        super();
    }

    Value(Node left, Node rite) {
        System.out.println("wrong constructor");

    }

    public void setType() {
        this.type = classType;
    }
}