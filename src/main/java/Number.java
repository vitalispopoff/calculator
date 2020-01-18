import java.util.ArrayList;
import java.util.List;

public class Number {

    private double value;

    Number() {
    }

    Number(String stringRepresentation) {
        this.value = Double.parseDouble(stringRepresentation);
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

    /*public static void main(String[] args) {
    }*/
}
