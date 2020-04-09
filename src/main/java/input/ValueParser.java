package input;

public class ValueParser implements Parsable {

    static String parserCache = null;

    @Override
    public void addCharToCache(char c) {
        parserCache += c;
    }

    @Override
    public boolean isNegative(){
        return parserCache.charAt(0) == 45;
    }

    @Override
    public boolean isFraction(){
        return parserCache.indexOf(46) != -1;
    }

    @Override
    public double clearCache() {
        double result = Double.valueOf(parserCache);
        parserCache = null;
        return result;
    }
}