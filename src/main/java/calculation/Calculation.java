package calculation;

import static java.lang.Double.NaN;

public abstract class Calculation extends Node {

    static NodeType classType = NodeType.OPERATOR;

    Calculation() {
        super();
    }

    Calculation(Node left) {
        super(left, null);
    }   // ? TODO this one might be disposable

    Calculation(Node left, Node rite) {
        super(left, rite);
        this.type = classType;
    }
}

/**
 * ? TODO : subclasses called by respective keys and/or GUI buttons ?
 */