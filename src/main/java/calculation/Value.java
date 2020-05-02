package calculation;

import static memory.Memory.*;

public class Value extends Node /*implements Parsable*/ {

/*    static Value
            currentValue = null;*/
/*    boolean
            isNegative = false;*/

    public Value() {
        super();
    }

    public Value(Typical type) {
        super(type);
    }

/*    static void resetCurrent() {
        currentValue = null;
    }*/

    @Override
    protected Double calculate(Nodeable localLeft, Nodeable localRite) {
        return value;
    }

/*    public void updateValueParser(char c) {
        if (c == '-') switchSign();
        else if (parserCacheIsNull()) addCharToCache(c);
        else try {
                String localCache = parserCache + c;
                Double.parseDouble(localCache);
                addCharToCache(c);
            } catch (NumberFormatException ignored) {
            }
    }*/

/*//    @Override
    public double clearCache() {
        double result = (parserCache == null && isNegative) || parserCache == "."
                ? 0
                : Double.valueOf(parserCache);
        if (isNegative) result *= -1.;
        parserCache = null;
        isNegative = false;
        return result;
    }*/

/*    @Override
    public void addCharToCache(char c) {
        parserCache += c;
    }*/

/*    void switchSign() {
        this.isNegative = !isNegative;
    }*/
}