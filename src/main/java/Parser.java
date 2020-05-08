public class Parser implements Parseable {

    static boolean isValueNegative = false;
    private static String parserCache = "";

    public static void addToParserCache(char c) {
        if (c == 8723) isValueNegative = !isValueNegative;
        else if (isParserAValue(c)) parserCache += c;
    }

    public static double dumpParserCache() {
        if (parserCache.length() == 0) return Double.NaN;
        double cache
                = isValueNegative
                ? -1. * Double.parseDouble(parserCache)
                : Double.parseDouble(parserCache);
        resetParser();
        return cache;
    }

    public static boolean isParserAValue() {
        return isParserAValue('\u0000');
    }

    static boolean isParserAValue(char c) {
        try {
            Double.parseDouble(parserCache + c);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void resetParser() {
        isValueNegative = false;
        parserCache = "";
    }

    static String getParserCache() {
        return parserCache;
    }
}