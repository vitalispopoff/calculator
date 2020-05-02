package memory;

import static memory.Memory.*;

import _notes._MemoryTest_Notes;
import input.NodeQueue;
import org.junit.*;

public class MemoryTest implements _MemoryTest_Notes {

    @Before
    public void initial() {
        parserCache = null;
        isValueNegative = false;
        mainQueue = new NodeQueue(null);
    }

    @Test
    public void initial_test() {
//        initial();
        Assert.assertNull(mainQueue.getHead());
        Assert.assertNull(mainQueue.getTail());
        Assert.assertNull(parserCache);
        Assert.assertFalse(isValueNegative);
    }

/*    @Test
    public void parserCacheIsNull_01() {
        parserCache = "1.0";
        Assert.assertNotNull(parserCache);
        Assert.assertFalse(Memory.isParserCacheNull());
    }*/

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Override
    public void addToParserCache_init() {
    }

    @Test
    public void addToParserCache_01() {
//        initial();
        addToParserCache('-');
        Assert.assertTrue(isValueNegative);
    }

    @Test
    public void addToParserCache_02() {
//        initial();
        isValueNegative = true;
        addToParserCache('-');
        Assert.assertFalse(isValueNegative);
    }

    @Test
    public void addToParserCache_03() {
//        initial();
        parserCache = ".";
        addToParserCache('.');
        Assert.assertEquals(1, parserCache.length());
    }

    @Test
    public void addToParserCache_04() {
//        initial();
        parserCache = "0.";
        Assert.assertEquals(0., Double.parseDouble(parserCache), 0.);
        addToParserCache('1');
        Assert.assertEquals(0.1, Double.parseDouble(parserCache), 0.1);
    }

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Override
    public void clearCache_init() {
    }

    @Test
    public void clearCache_01() {
        Assert.assertNull(parserCache);
        Assert.assertFalse(isValueNegative);

        Assert.assertEquals(Double.NaN, clearCache(), 0.);
    }

//    @Test
    /*public void clearCache_02() {
        parserCache = ".";
        Assert.assertEquals(0., clearCache(), 0.);
    }*/

    @Test
    public void clearCache_03() {
//        initial();
        parserCache = "0.1";
        isValueNegative = true;
        Assert.assertEquals(-0.1, clearCache(), 0.);

    }

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Test
    public void isParserCacheAValue_01(){
//        initial();
        Assert.assertNull(parserCache);
//        Assert.assertFalse(isParserCacheAValue());
    }

    @Test
    public void isParserCacheAValue_02(){
//        initial();
        parserCache = ".";
        Assert.assertTrue(isParserCacheAValue());
    }

    @Test
    public void isParserCacheAValue_03(){
//        initial();
        isValueNegative = true;
        Assert.assertTrue(isParserCacheAValue());
    }

    @Test
    public void isParserCacheAValue_04(){
//        initial();
        parserCache = "";
        Assert.assertFalse(isParserCacheAValue());
    }
}