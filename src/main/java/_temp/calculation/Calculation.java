package _temp.calculation;

public abstract class Calculation extends Node{

    protected Calculation() {
        super();
    }

    Calculation(Node left) {
        super(left, null);
    }
}