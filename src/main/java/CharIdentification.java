public interface CharIdentification {

    static CharType whatType(char a){
        CharType result = CharType.UNSUPPORTED;
        if (isInt(a)) result = CharType.INT;
        else if(isAlgebraicOperator(a)) result= CharType.OPERATOR;
        else if(isBracketOn(a)) result = CharType.BRACKET_ON;
        else if(isBracketOff(a)) result = CharType.BRACKET_OFF;

        return result;
    }

    static boolean isInt(char a) {return (a > 47 & a < 57 )|| a == 46;}

    static int toInt(char a) {return ((int) a) - 48;}

    static boolean isRadixPoint(char a) {return (int) a == 46;}

    static boolean isBracketOn(char a){return((int)a == 40);}

    static boolean isBracketOff(char a){return((int)a == 41);}

    static boolean isAlgebraicOperator(char a) {return ((int) a) >> 1 == 21 || (int) a == 45 || (int) a == 47;}

    static boolean isEquationOperator(char a) {return (int) a == 61;}

    static char fromInt(int i) {return (char) (i + 48);}
}
