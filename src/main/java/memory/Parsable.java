package memory;

/**
 * <!---->
 * <p>Provides the logic of parsing,
 * and assembling a number value for the equation tree,
 * as well as wrapping it into  a tree compliant object.
 * to communicate directly to value class.</p>
 * */
public interface Parsable {

    /**
     * <!---->
     * <p>Adds a character to the end of parsing string<br>
     *
     * @param c the character written via keyboard.
     *          </p>
     */
     void addCharToCache(char c);

    /**
     * <!---->
     * <p>Returns the cache value as double, and resets the cache.</p>
     */
     double clearCache();
}