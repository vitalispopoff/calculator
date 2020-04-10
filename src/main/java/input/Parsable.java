package input;

/**
 * the interface provides a logic of parsing,
 * and assembling a number value for the equation tree,
 * as well as wrapping it into  a tree compliant object.
 * to communicate directly to value class
 * */
public interface Parsable {

    /**
     * Adds a character to the end of the string
     *
     * @param c the character written via keyboard
     */
     void addCharToCache(char c);


    /**
     * returns the cache value as double,
     * and resets the cache.
     */
     double clearCache();


     /**
      *
      * */
     static void valueWriter(char c){
         if (c == '&') new ValueParser();
         else new ValueParser(c);
     }
}