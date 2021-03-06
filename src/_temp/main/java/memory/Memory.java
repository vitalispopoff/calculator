package memory;

import calculation.Nodeable;
import calculation.otherExpressions.Value;
import input.*;

import static calculation.NodeType.VALUE;

public abstract class Memory implements Parsable {

    public static boolean isValueNegative = false;
    public static String parserCache = "";
    public static Queuing mainQueue = new NodeQueue(null);

    public static boolean isParserCacheAValue() {
        return (isValueNegative || (cacheHasChars()));
    }

    public static double clearCache() {
        double result = Double.NaN;

        if (isParserCacheAValue()) {
            if (isValueNegative && cacheHasNoChars()) result = 0.;
            else result
                    = isValueNegative
                    ? -1. * Double.parseDouble(parserCache)
                    : Double.parseDouble(parserCache);
        }
        reset();
        return result;
    }

    public static void addToParserCache(char c) {
        if (c == '∓') switchSign();
        else if (isCacheNull()) addCharToCache(c);
        else try {
                String localCache = parserCache + c;
                Double.parseDouble(localCache);
                addCharToCache(c);
            } catch (NumberFormatException ignored) {
            }
    }

    public static void dumpParserCache() {
        System.out.println("dupa");
        if (isParserCacheAValue()) {
            double
                    val = clearCache();
            Nodeable
                    nod = new Value(VALUE, val);
            Queueable
                    queuer = new Queuer(nod);
            mainQueue.updateQueue(queuer);

            System.out.println("dumpParserCache() : the value added to the mainQueue");
        } else System.out.println("dumpParserCache() : no value to add to the mainQueue");
    }

    //    @formatter:off

    public static void switchSign() { isValueNegative = !isValueNegative; }
    public static void reset(){isValueNegative = false; parserCache = "";}

    private static void addCharToCache(char c) { parserCache += c; }

    private static boolean isCacheNull() { return parserCache == null; }
    private static boolean isCacheNotNull() { return !isCacheNull(); }
    private static boolean cacheHasChars() { return isCacheNotNull() && parserCache.length() > 0; }
    private static boolean cacheHasNoChars(){return !cacheHasChars();}

    //    @formatter:on
}