import org.junit.*;

public class ParsableTest {

    @Before
    public void initial(){
        Parser.resetParser();
    }

//\\ isParserAValue //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Test
    public void isParserAValue_01(){
        Assert.assertFalse(Parser.isParserAValue());
    }

    @Test
    public void isParserAValue_02(){
        Parser.addToParserCache('0');
        Assert.assertTrue(Parser.isParserAValue());
    }

    @Test
    public void isParserAValue_03(){
        Parser.addToParserCache('0');
        Parser.addToParserCache('.');
        Assert.assertTrue(Parser.isParserAValue());
    }

//\\ addToParserCache \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Test
    public void addToParserCache_01(){
        Assert.assertEquals(0, Parser.getParserCache().length());
        Parser.addToParserCache('1');
        Assert.assertEquals(1, Parser.getParserCache().length());
    }

    @Test
    public void addToParserCache_02(){
        Assert.assertEquals(0, Parser.getParserCache().length());

        Parser.addToParserCache('z');
        Assert.assertEquals(0, Parser.getParserCache().length());
    }

    @Test
    public void addToParserCache_03(){
        Parser.addToParserCache('0');
        Assert.assertEquals(1, Parser.getParserCache().length());
        Parser.addToParserCache('.');
        Assert.assertEquals("0.", Parser.getParserCache());
    }

//\\ dumpParserCache  \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Test
    public void dumpParserCache_01(){
        Parser.addToParserCache('1');
        Parser.addToParserCache('∓');
        Assert.assertTrue(Parser.isValueNegative);

        Parser.addToParserCache('.');
        Parser.addToParserCache('5');
        Assert.assertEquals(-1.5, Parser.dumpParserCache(), 0.);
        Assert.assertEquals(0, Parser.getParserCache().length());
        Assert.assertFalse(Parser.isValueNegative);
    }

    @Test
    public void dumpParserCache_02(){
        Assert.assertEquals(Double.NaN, Parser.dumpParserCache(), 0.);

    }
}