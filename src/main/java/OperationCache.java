import java.util.List;

public class OperationCache {

    String input;
    Number arg1;
    Number arg2;
    AlgebraicOperational operation;
    Number operationResult;


    public static String operate(String a) {

        String result = "";

        return result;
    }

    static Number extractArgument1(String input) {
        int opIdx = getOperatorIndex(input);
        String argRepresent = input.substring(0, opIdx -1);
        return new Number(argRepresent);
    }

    static Number extractArgument2(String input) {
        int opIdx = getOperatorIndex(input);
        String argRepresent = input.substring(opIdx + 1);
        return new Number(argRepresent);
    }

    static int getOperatorIndex(String input) {
        int result=-1;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(InputDataStreamReading.isAlgebraicOperator(c)){
                result = i;
                i = input.length();
            }
        }
        return result;
    }
}
