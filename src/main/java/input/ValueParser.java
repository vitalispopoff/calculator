package input;

public class ValueParser implements Parsable{

    static String parserCache = null;
    static boolean isNegative = false;

    ValueParser() {
    }

    public ValueParser(char c) {
        if (c == '-') switchSign();
        else if (parserCache == null) addCharToCache(c);
        else try {
                String localCache = parserCache + c;
                parserCacheToStream(localCache);
                addCharToCache(c);
            } catch (NumberFormatException e) {
            }
    }

    /*public*/ static void switchSign() {
        isNegative = !isNegative;
    }

    public /*static*/ void addCharToCache(char c) {
        parserCache += c;
    }

    static double parserCacheToStream(String stream) {
        return Double.parseDouble(stream);
    }

    public double clearCache() {
        double result = (parserCache == null && isNegative) || parserCache == "."
                ? 0
                : Double.valueOf(parserCache);
        if (isNegative) result *= -1.;
        parserCache = null;
        isNegative = false;
        return result;
    }
}