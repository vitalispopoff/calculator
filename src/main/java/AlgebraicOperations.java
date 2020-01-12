//package;

//import;

public class AlgebraicOperations implements AlgebraicOperational {

    private int a;
    private int b;

    AlgebraicOperations(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int add() {
        return a + b;
    }

    @Override
    public int subtract() {
        return a - b;
    }

    @Override
    public int multiply() {
        return a * b;
    }

    @Override
    public int divide() {
        if (b == 0) throw new IllegalArgumentException();
        else return Math.round((float)a / (float)b);
    }
}
