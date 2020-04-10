package input;

public class ValueParser {

    static String parserCache = null;
    static boolean isNegative = false;

    private ValueParser() {
    }

    public ValueParser(char c) {
        if (c == '-') isNegative = !isNegative;
        else if (parserCache == null) addCharToCache(c);
        else try {
                String localCache = parserCache + c;
                parserCacheToStream(localCache);
                addCharToCache(c);
            } catch (NumberFormatException e) {
            }
    }

    public static void switchSign() {
        isNegative = !isNegative;
    }

    public static void addCharToCache(char c) {
        parserCache += c;
    }

    static double parserCacheToStream(String stream) {
        return Double.parseDouble(stream);
    }

    public static double clearCache() {
        double result = (parserCache == null && isNegative) || parserCache == "."
                ? 0
                : Double.valueOf(parserCache);
        if (isNegative) result *= -1.;
        parserCache = null;
        isNegative = false;
        return result;
    }
}