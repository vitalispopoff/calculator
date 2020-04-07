package calculation;

public abstract class Calculation extends Node {

    static NodeType classType = NodeType.OPERATOR;

    Calculation(Node left, Node rite) {
        super(left, rite);
        this.type = classType;
    }
}

/**
 * ? TODO : subclasses called by respective keys and/or GUI buttons ?
 */