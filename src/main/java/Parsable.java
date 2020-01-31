import java.util.ArrayList;
import java.util.List;

public class Parsable {

    private static String parsed = "";
    static List<Parsable> parsableDepot = new ArrayList<>();

    static void streamAssembler(char character) {
        String parseCache = parsed + character;
        try {
            streamToValue(parseCache);
            parsed += character;

        } catch (NumberFormatException e) {
            try {
                streamToValue(parsed);
                parsableDepot.add(new Parsable(streamToValue(parsed), CharType.NUMBER));

            } catch (NumberFormatException f) {
                if (CharIdentification.whatType(character) == CharType.OPERATOR) {
                    int temp = CharIdentification.toAlgebraicOperator(character);
                    parsableDepot.add(new Parsable((double)temp, CharType.OPERATOR));


                }
            }
            resetParsed();
        }
    }

    static double streamToValue(String stream) {
        return Double.parseDouble(stream);
    }

    private static void resetParsed() {
        parsed = "";
    }

    /*static String valueToStream(double argument) { return Double.toString(argument); }*/  //    ! probably disposable

    private CharType type;
    private double temporalValue;

    private Parsable(double temporalValue, CharType type) {
        setTemporalValue(temporalValue);
        setType(type);
    }

    private void setTemporalValue(double temporalValue) {
        this.temporalValue = temporalValue;
    }

    double getTemporalValue() {
        return temporalValue;
    }

    private void setType(CharType type) {
        this.type = type;
    }

    CharType getType() {
        return type;
    }

    public static void main(String[] args) {

        resetParsed();
        String data = "*1.01-";
        for (int i = 0; i < data.length(); i++) {
            streamAssembler(data.charAt(i));
        }

        System.out.println(parsableDepot.get(0).getTemporalValue());

    }
}


