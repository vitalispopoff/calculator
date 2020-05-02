package memory;

import calculation.*;
import input.*;

public abstract class Memory implements Parsable {

    public static String parserCache = null;
    private static boolean parserCacheValueIsNegative = false;

    public static Queuing mainQueue = new NodeQueue(null);

    public static boolean parserCacheIsNull() {
        return parserCache == null;
    }

    public void addToParserCache(char c) {
        if (c == '-') switchSign();
        else if (parserCacheIsNull()) addCharToCache(c);
        else try {
                String localCache = parserCache + c;
                Double.parseDouble(localCache);
                addCharToCache(c);
            } catch (NumberFormatException ignored) {
            }
    }

    protected Nodeable calculate(Nodeable localLeft, Nodeable localRite) {
        Nodeable cache = NodeType.VALUE.interact();
        cache.setValue(0.);

        return cache;
    }

    @Override
    public double clearCache() {
        double result = (parserCache == null && parserCacheValueIsNegative) || parserCache == "."
                ? 0
                : Double.valueOf(parserCache);
        if (parserCacheValueIsNegative) result *= -1.;
        parserCache = null;
        parserCacheValueIsNegative = false;
        return result;
    }

    @Override
    public void addCharToCache(char c) {
        parserCache += c;
    }

    public static void switchSign() {
        parserCacheValueIsNegative = !parserCacheValueIsNegative;
    }
}