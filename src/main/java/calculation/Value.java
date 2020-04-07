package calculation;

public class Value extends Node {

    static final NodeType classType = NodeType.OPERATOR;

    Value(double value) {
        super(value);
        this.type = classType;
    }

    Value() {
        super();
        this.type = classType;
    }

    Value(Node left, Node rite) {
        System.out.println("wrong constructor");
        this.type = classType;
    }

    public static void main(String[] args) {
        Node val = new Value();
    }

}