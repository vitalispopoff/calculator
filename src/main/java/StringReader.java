// package;

// import;

public class StringReader {

    static boolean isInt(char a) {
        boolean result = a > 47 && a < 57;
        return result;
    }

    static int toInt(char a) {
        return ((int) a) - 48;
    }

    static boolean isRadixPoint(char a) {
        return (int) a == 46;
    }

    static boolean isBracket(char a) {
        boolean result = ((int) a) >> 1 == 20;
        return result;
    }

    static boolean isAlgebraicOperator(char a) {
        boolean result = ((int) a) >> 1 == 21 || (int) a == 45 || (int) a == 47;
        return result;
    }

    static boolean isEquationOperator(char a) {
        return (int) a == 61;
    }


}
