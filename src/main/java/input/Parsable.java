package input;

/**
 * :
 * Provides the logic of parsing,
 * and assembling a number value for the equation tree,
 * as well as wrapping it into  a tree compliant object.
 * to communicate directly to value class
 * */
public interface Parsable {

    /**
     * :
     * Adds a character to the end of parsing string
     *
     * @param c the character written via keyboard
     */
     void addCharToCache(char c);

    /**
     * :
     * Returns the cache value as double,
     * and resets the cache.
     */
     double clearCache();
}