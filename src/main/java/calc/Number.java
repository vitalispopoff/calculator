package calc;

public class Number {

    private double value;

    Number() {
    }

    Number(String stringRepresentation) {

        this.value = Double.parseDouble(stringRepresentation);  //parseDouble() and valueOf() loses last digit of the fraction part... WTF!
    }

    static Double stringToValue(String string){
        double result= 0.0;
        int opIdx = OperationCache.getOperatorIndex(string);



        return result;
    }

    static String valueToString(double value) {
        return "" + value;
    }

    String valueToString(){
        return Double.toString(value);
    }

    double getValue() {
        return value;
    }

    void setValue(double value) {
        this.value = value;
    }

    void setValue(String s){
        this.value = Double.valueOf(s);
    }

    /*public static void main(String[] args) {
    }*/
}
