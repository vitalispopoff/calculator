public interface CharIdentification {

    static CharType whatType(char a) {
        CharType result = CharType.UNSUPPORTED;
        if (isInt(a)) result = CharType.INT;
        else if (isAlgebraicOperator(a)) result = CharType.OPERATOR;
        else if (isBracketOn(a)) result = CharType.BRACKET_ON;
        else if (isBracketOff(a)) result = CharType.BRACKET_OFF;

        return result;
    }

    static boolean isInt(char a) {
        return (a > 47 & a < 57) || a == 46;
    }

    static int toInt(char a) {
        return ((int) a) - 48;
    }

    static boolean isRadixPoint(char a) {
        return (int) a == 46;
    }

    static boolean isBracketOn(char a) {
        return ((int) a == 40);
    }

    static boolean isBracketOff(char a) {
        return ((int) a == 41);
    }

    static boolean isAlgebraicOperator(char a) {
        return ((int) a) >> 1 == 21 || (int) a == 45 || (int) a == 47;
    }

    static int toAlgebraicOperator(char a) {
        /*int result = 0;
        switch (a) {
            case 42:
                result = 1;
                break;
            case 43:
                result = 2;
                break;
            case 45:
                result = 3;
                break;
            case 47:
                result = 4;
                break;
        }
        return result;*/        // we don't like switch, do we?
        return (a-39)>>1;
    }

    /*
    * 42 = 1 ; 3 = 1
    * 43 = 2 ; 4 = 2
    * 45 = 3 ; 6 = 3
    * 47 = 4 ; 8 = 4
    * */

    static boolean isEquationOperator(char a) {
        return (int) a == 61;
    }

    static char fromInt(int i) {
        return (char) (i + 48);
    }

    public static void main(String[] args) {
        System.out.println((42-39)>>1);
        System.out.println((43-39)>>1);
        System.out.println((45-39)>>1);
        System.out.println((47-39)>>1);
    }
}