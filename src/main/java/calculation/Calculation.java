package calculation;




public abstract class Calculation extends Node{

    protected Calculation() {
        super();
    }

    Calculation(Node left) {
        super(left, null);
    }

    protected Calculation(Node left, Node rite) {
        super(left, rite);
    }


}
