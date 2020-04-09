package input;

/**
 * the interface provides a logic of parsing,
 * and assembling a number value for the equation tree,
 * as well as wrapping it into  a tree compliant object.
 * */
public interface Parsable {

    /**
     * Adds a character to the end of the string
     *
     * @param c the character written via keyboard
     */
    void addCharToCache(char c);

    /**
     * verifies whether the number is negative,
     * this shifts the content of the number string
     * by one slot, the string begins with char 45
     */
    boolean isNegative();

    /**
     * verifies whether the number is a fraction,
     * this indicates, that the string contains
     * a fraction mark (char 46, point),
     * in that case the string cannot accept
     * char 46 anymore
     */
    boolean isFraction();

    /**
     * returns the cache value as double,
     * and resets the cache.
     */
    double clearCache();
}