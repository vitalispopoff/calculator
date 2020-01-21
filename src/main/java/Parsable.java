import java.util.ArrayList;
import java.util.List;

public class Parsable {

    static String parsed = "";
    static List<Parsable> parsableDepot = new ArrayList<>();

/*    static double streamAssembler(char c) {
        double result = parsed.length() > 0 ? streamToValue(parsed) : 0.;
        String parseCache = parsed + c;

        try {
            streamToValue(parseCache);
            result = streamToValue(parsed += c);
        } catch (NumberFormatException e) {
            parsableDepot.add(new Parsable(streamToValue(parsed)));
            resetParsed();
        }
        return result;
    }*/     // TODO disposable ?

    static void streamAssembler(char c) {
        String parseCache = parsed + c;
        try {
            streamToValue(parseCache);
            parsed += c;
        }
        catch (NumberFormatException e) {
            try {
                streamToValue(parsed);
                parsableDepot.add(new Parsable(streamToValue(parsed)));
            }
            catch (NumberFormatException f) {
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

    private double temporalValue;

    private Parsable(double temporalValue) {
        setTemporalValue(temporalValue);
    }

    private void setTemporalValue(double temporalValue) {
        this.temporalValue = temporalValue;
    }

    double getTemporalValue() {
        return temporalValue;
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


