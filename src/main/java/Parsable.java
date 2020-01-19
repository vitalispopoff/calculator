import java.util.ArrayList;
import java.util.List;

public class Parsable {

    static String parsed = "";
    static List<String> stack = new ArrayList<>();



    static double streamAssembler(char c) {
        double result = parsed.length() > 0 ? streamToValue(parsed) : 0.;
        String parseCache = parsed + c;

        try {
            streamToValue(parseCache);
            result = streamToValue(parsed += c);
        } catch (NumberFormatException e) {
            resetParsed();
        }
        return result;
    }

    static double streamToValue(String stream) { return Double.parseDouble(stream); }

    static void resetParsed() { parsed = ""; }

    static String valueToStream(double argument) { return Double.toString(argument); }

    public static void main(String[] args) {

        resetParsed();

        String stream = "0.01-1";

        for (int i = 0; i < stream.length(); i++) {
            System.out.println(i + ") " + stream.charAt(i) + " : " + streamAssembler(stream.charAt(i)));
            System.out.println("current parsed: "+parsed);

        }
    }
}


