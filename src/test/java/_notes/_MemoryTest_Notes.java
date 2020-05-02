package _notes;

public interface  _MemoryTest_Notes {

    /**
     *  <p>static void addToParserCache() tests : </p>
     * <ol>
     *     <li>switching the sign to negative</li>
     *     <li>switching the sign to positive</li>
     *     <li>adding another '.'</li>
     *     <li>adding a proper character</li>
     *
     * </ol>
     * */
    void addToParserCache_init();


    /**
     * <p>static void clearCache() tests: </p>
     * <ol>
     *     <li>testing empty cache</li>
     *     <li>cache "." <s>returns 0.</s> returns NaN</li>
     *     <li>cache contains proper number</li>
     * </ol>
     * */
    void clearCache_init();


}