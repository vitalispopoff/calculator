package calculation;

public abstract class Calculation extends Node {

    static NodeType classType = NodeType.OPERATOR;

    protected Calculation() {
        super();
    }

    Calculation(Node left) {
        super(left, null);
    }   // ? TODO this one might be disposable

    protected Calculation(Node left, Node rite) {
        super(left, rite);
        this.type = classType;
    }
}
