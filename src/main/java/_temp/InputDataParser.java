package _temp;

public class InputDataParser {

    static String parsed = "";              // access from private to default because ParsableTest
    private CharType type;
    private double temporalValue;

    static void resetParsed() {
        parsed = "";
    }

    static double streamToValue(String stream) {
        return Double.parseDouble(stream);
    }

    static void streamAssembler(char number) {
        String parseCache = parsed + number;

        try {
            streamToValue(parseCache);
            parsed += number;
        } catch (NumberFormatException e) {
            try {
                streamToValue(parsed);
//                inputDataParserDepot.add(new InputDataParser(streamToValue(parsed), CharType.NUMBER));
            } catch (NumberFormatException f) {
                if (CharIdentification.whatType(number) == CharType.OPERATOR) {
                    int temp = CharIdentification.toAlgebraicOperator(number);
//                    inputDataParserDepot.add(new InputDataParser((double)temp, CharType.OPERATOR));
                }
            }
            resetParsed();
        }
    }

    private InputDataParser(double temporalValue, CharType type) {
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
}


