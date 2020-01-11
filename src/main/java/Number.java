import java.util.ArrayList;
import java.util.List;

public class Number {


    static double convertToNumber(String a) {
        double result = 0.;
        List<Character> charSeries = sliceToSeries(a);
        if (isSeriesProperNumber(charSeries)) {

        }
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

    static boolean isSeriesProperNumber(List<Character> charSeries) {
        boolean result = true;
        int radixPoints = 0;
        for (char c : charSeries) {
            if (InputDataStreamReading.isRadixPoint(c)) radixPoints++;
            if ((!InputDataStreamReading.isInt(c) && radixPoints > 1) || charSeries.size() == radixPoints)
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
}
