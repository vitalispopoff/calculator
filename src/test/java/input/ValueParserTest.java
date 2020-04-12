package input;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static input.ValueParser.*;

public class ValueParserTest {

    @Before
    public void resetSystem() {
        parserCache = null;
        isNegative = false;
    }

    @Test
    public void ValueParser_00() {
        Assert.assertNull(parserCache);
    }

    @Test
    public void ValueParser_02() {
        new ValueParser('.');
        Assert.assertNotNull(parserCache);
        Assert.assertFalse(isNegative);
    }

    @Test
    public void ValueParser_03() {
        new ValueParser('-');
        new ValueParser('0');
        new ValueParser('.');
        new ValueParser('1');
        Assert.assertNotNull(parserCache);
        Assert.assertTrue(isNegative);
    }

    @Test
    public void parserCacheToStream_01() {
        String n = "1.0";
        Assert.assertEquals(1., parserCacheToStream(n), 0.);
    }

    @Test
    public void clearCache_0() {
        parserCache = "1.0";
        Assert.assertNotNull(parserCache);
        Assert.assertFalse(isNegative);
        Assert.assertEquals(1., new ValueParser().clearCache(), 0.);
    }

    @Test
    public void clearCache_01() {
        parserCache = ".";
        Assert.assertEquals(0., new ValueParser().clearCache(), 0.);
    }

    @Test
    public void clearCache_02() {
        parserCache = null;
        isNegative = true;
        Assert.assertEquals(0., new ValueParser().clearCache(), 0.);
    }
}