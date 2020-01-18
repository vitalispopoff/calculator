package calc;//import java.util.List;

public class OperationCache {

    static double operate(String a) {
        int opIdx = getOperatorIndex(a);
        Number arg1 = extractArgument1(a, opIdx);
        Number arg2 = extractArgument2(a, opIdx);
        char operator = a.charAt(opIdx);
        Number result = new Number("0");

        if (operator == 42) result = AlgebraicOperational.multiply(arg1, arg2);
        else if(operator ==43) result = AlgebraicOperational.add(arg1, arg2);
        else if(operator==45) result = AlgebraicOperational.subtract(arg1, arg2);
        else if(operator==47) result = AlgebraicOperational.divide(arg1, arg2);

//        return result.valueToString();
        return result.getValue();

    }

    static Number extractArgument1(String input) {
        int opIdx = getOperatorIndex(input);
        String argRepresent = input.substring(0, opIdx - 1);
        return new Number(argRepresent);
    }

    static Number extractArgument1(String input, int opIdx) {
        String argRepresent = input.substring(0, opIdx);
        return new Number(argRepresent);
    }

    static Number extractArgument2(String input) {
        int opIdx = getOperatorIndex(input);
        String argRepresent = input.substring(opIdx + 1);
        return new Number(argRepresent);
    }

    static Number extractArgument2(String input, int opIdx) {
        String argRepresent = input.substring(opIdx + 1);
        return new Number(argRepresent);
    }

    static int getOperatorIndex(String input) {
        int result = -1;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (InputDataStreamReading.isAlgebraicOperator(c)) {
                result = i;
                i = input.length();
            }
        }
        return result;
    }
}
