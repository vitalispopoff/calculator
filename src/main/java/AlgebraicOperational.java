//package;

//import;

public interface AlgebraicOperational {

    int addition();

    int subtraction();

    int multiplication();

    int division();

    static Number add(Number augend, Number addend) {
        Number result = new Number();
        result.setValue(augend.getValue() + addend.getValue());
        return result;
    }

//    Number subtract(Number a);

//    Number multiply(Number a);

//    Number divide(Number a);
}
