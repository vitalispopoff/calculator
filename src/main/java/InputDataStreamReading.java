// package;

// import;

public interface InputDataStreamReading {

    static boolean isInt(char a) {return a > 47 && a < 57;}

    static int toInt(char a) {return ((int) a) - 48;}

    static boolean isRadixPoint(char a) {return (int) a == 46;}

    static boolean isBracket(char a) {return ((int) a) >> 1 == 20;}

    static boolean isAlgebraicOperator(char a) {return ((int) a) >> 1 == 21 || (int) a == 45 || (int) a == 47;}

    static boolean isEquationOperator(char a) {return (int) a == 61;}
}
