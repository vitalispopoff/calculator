package calculation;

public abstract class Calculation extends Node{

    static NodeType classType = NodeType.OPERATOR;

    protected Calculation() {
        super();
    }

    Calculation(Node left) {
        super(left, null);
    }

    protected Calculation(Node left, Node rite) {
        super(left, rite);
    }

    public void setType() {
        this.type = classType;
    }
}
