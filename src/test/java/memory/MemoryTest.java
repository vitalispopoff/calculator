package memory;

import static memory.Memory.*;

import org.junit.*;
import input.NodeQueue;
import _notes._MemoryTest_Notes;

public class MemoryTest implements _MemoryTest_Notes {

    @Before
    public void initial() {
        parserCache = null;
        isValueNegative = false;
        mainQueue = new NodeQueue(null);
    }

    @Test
    public void initial_test() {
        Assert.assertNull(mainQueue.getHead());
        Assert.assertNull(mainQueue.getTail());
        Assert.assertNull(parserCache);
        Assert.assertFalse(isValueNegative);
    }

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Override
    public void addToParserCache_init() {
        addToParserCache('∓');
    }

    @Test
    public void addToParserCache_01() {
        addToParserCache_init();
        Assert.assertTrue(isValueNegative);
    }

    @Test
    public void addToParserCache_02() {
        isValueNegative = true;
        addToParserCache_init();
        Assert.assertFalse(isValueNegative);
    }

    @Test
    public void addToParserCache_03() {
        parserCache = ".";
        addToParserCache('.');
        Assert.assertEquals(1, parserCache.length());
    }

    @Test
    public void addToParserCache_04() {
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

    @Test
    public void clearCache_03() {
        parserCache = "0.1";
        isValueNegative = true;
        Assert.assertEquals(-0.1, clearCache(), 0.);
    }

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Test
    public void isParserCacheAValue_01() {
        Assert.assertNull(parserCache);
    }

    @Test
    public void isParserCacheAValue_02() {
        parserCache = ".";
        Assert.assertTrue(isParserCacheAValue());
    }

    @Test
    public void isParserCacheAValue_03() {
        isValueNegative = true;
        Assert.assertTrue(isParserCacheAValue());
    }

    @Test
    public void isParserCacheAValue_04() {
        parserCache = "";
        Assert.assertFalse(isParserCacheAValue());
    }
}