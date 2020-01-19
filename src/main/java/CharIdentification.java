
public interface CharIdentification {

    static CharType whatType(char a){
        CharType result = null;
        if (isInt(a)) result = CharType.INT;
        else if(isAlgebraicOperator(a)) result= CharType.OPERATOR;
        else if(isBracket()) result = CharType.BRACKET;


        return CharType.INT;
    }

    static boolean isInt(char a) {return (a > 47 & a < 57 )|| a == 46;}

    static int toInt(char a) {return ((int) a) - 48;}

    static boolean isRadixPoint(char a) {return (int) a == 46;}

    static boolean isBracket(char a) {return ((int) a) >> 1 == 20;}

    static boolean isAlgebraicOperator(char a) {return ((int) a) >> 1 == 21 || (int) a == 45 || (int) a == 47;}

    static boolean isEquationOperator(char a) {return (int) a == 61;}

    static char fromInt(int i) {return (char) (i + 48);}
}

enum CharType{

    INT,
    BRACKET,
    OPERATOR,

}
