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

    static Number subtract(Number minuend, Number subtrahent) {
        Number result = new Number();
        result.setValue(minuend.getValue() - subtrahent.getValue());
        return result;
    }

    static Number multiply(Number multiplier, Number multiplicant) {
        Number result = new Number();
        result.setValue(multiplier.getValue() * multiplicant.getValue());
        return result;
    }

    static Number divide(Number dividend, Number divisor){
        Number result;
        if(divisor.getValue()==0.0) throw new IllegalArgumentException();
        else{
        result = new Number();
        result.setValue(dividend.getValue() / divisor.getValue());
        }
        return result;      // TODO test: for exception scenario the result is not initialized but returned either, is it?
    }
}
