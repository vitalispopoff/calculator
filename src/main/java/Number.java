import java.util.ArrayList;
import java.util.List;

public class Number {

    double value;
    String stringRepresentation;
    List<Character> charSeries;

//  * to be used in NumberTest only
    Number(){}

    public Number(String stringRepresentation){
        if(!isStringProperNumber(stringRepresentation)) throw new IllegalArgumentException();
        else{
            this.stringRepresentation = stringRepresentation;
            this.charSeries = sliceToSeries(stringRepresentation);
            this.value = extractIntegerPartOfCharSeries(charSeries) + extractFractionPartOfCharSeries(charSeries);
        }
    }

    static double convertToNumber(String a) {
        double result = 0.;
        List<Character> charSeries = sliceToSeries(a);
        /*if (isSeriesProperNumber(charSeries)) {*/
            result += extractIntegerPartOfCharSeries(charSeries);
            result += extractFractionPartOfCharSeries(charSeries);
        /*}*/
        return result;
    }

    static List<Character> sliceToSeries(String a) {
        List<Character> charSeries = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            charSeries.add(c);
        }
        return charSeries;
    }

    /*static boolean isSeriesProperNumber(List<Character> charSeries) {
        boolean result = true;
        int radixPointInstances = 0;
        for (char c : charSeries) {
            if (InputDataStreamReading.isRadixPoint(c)) radixPointInstances++;
            if ((!InputDataStreamReading.isInt(c) && radixPointInstances > 1) || charSeries.size() == radixPointInstances)
                result &= false;
        }
        return result;
    }*/

    static boolean isStringProperNumber(String number){
        boolean result = true;
        int radixPointInstances =0;
        for(int i = 0; i<number.length(); i++){
            char c = number.charAt(i);
            if(InputDataStreamReading.isRadixPoint(c)) radixPointInstances++;
            if((!InputDataStreamReading.isInt(c) && radixPointInstances > 1) || number.length() == radixPointInstances)
                result &= false;
        }
        return result;
    }

    static double extractIntegerPartOfCharSeries(List<Character> charSeries) {
        double result = 0.;
        int numberLength = charSeries.indexOf('.') - 1;

        for (int i = 0; i <= numberLength; i++) {
            int digit = InputDataStreamReading.toInt(charSeries.get(i));
            result += digit * Math.pow(10, numberLength - i);
        }
        return result;
    }

    static double extractFractionPartOfCharSeries(List<Character> charSeries) {
        double result = .0;
        int numberStart = charSeries.indexOf('.') + 1;

        for (int i = numberStart; i < charSeries.size(); i++) {
            int digit = InputDataStreamReading.toInt(charSeries.get(i));
            result += digit * Math.pow(10, numberStart - i - 1);
        }
        return result;
    }

}
