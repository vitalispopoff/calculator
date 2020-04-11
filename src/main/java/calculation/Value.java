package calculation;




public class Value extends Node {

    static final NodeType classType = NodeType.VAL;

    public Value(double value) {
        super(value);
    }

    public Value() {
        super();
    }

/*    Value(Node left, Node rite) {
        System.out.println("wrong constructor");

    }*/     // disposable

    @Override
    public void setType() {
        this.type = classType;
    }
}