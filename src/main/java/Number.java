import java.util.ArrayList;
import java.util.List;

public class Number {


    static int convertToNumber(String a) {
        return 0;
    }

    static List<Character> sliceToSeries(String a) {
        List<Character> charSeries = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (InputDataStreamReading.isInt(c) || InputDataStreamReading.isRadixPoint(c))
                charSeries.add(c);
        }
        return charSeries;
    }

}
