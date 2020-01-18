package _temporals;//package;

//import;

public class AlgebraicOperation implements AlgebraicOperational {

    private int a;
    private int b;

    AlgebraicOperation(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int addition() {
        return a + b;
    }

    @Override
    public int subtraction() {
        return a - b;
    }

    @Override
    public int multiplication() {
        return a * b;
    }

    @Override
    public int division() {
        if (b == 0) throw new IllegalArgumentException();
        else return Math.round((float)a / (float)b);
    }
}