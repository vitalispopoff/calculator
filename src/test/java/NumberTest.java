// package;

import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberTest {

    @Test
    public void numberTest01(){
        Number number = new Number("1.1");
        Number test = new Number();
        Assert.assertEquals(test.getClass(), number.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void numberTest02(){new Number("1..1");}

    @Test
    public void isStringProperNumberTest01(){
        Assert.assertTrue(Number.isStringProperNumber("1.1"));
    }

    @Test
    public void isStringProperNumberTest02(){
        Assert.assertFalse(Number.isStringProperNumber("1..1"));
    }

    @Test
    public void isStringProperNumberTest03(){
        Assert.assertFalse(Number.isStringProperNumber("."));
    }

    //  TODO standard electronic calculator behaviour - do we want it as well?
    @Test
    public void isStringProperNumberTest04(){
        Assert.assertTrue(Number.isStringProperNumber(".0"));
    }

    private List<Character> result;

    @Test
    public void sliceToSeriesTest01(){
        result = new ArrayList<>(Arrays.asList('1','.','1'));
        Assert.assertEquals(result, Number.sliceToSeries("1.1"));
    }

    @Test
    public void sliceToSeriesTest02(){
        result = new ArrayList<>(Arrays.asList('1','a','.','1'));
        Assert.assertEquals(result, Number.sliceToSeries("1a.1"));
    }



    @Test
    public void extractIntegerPartOfCharSeriesTest01(){
        result = new ArrayList<>(Arrays.asList('1','1','.','1'));
        Assert.assertEquals(11.d, Number.extractIntegerPartOfCharSeries(result),0.d);
    }

    @Test
    public void extractFractionPartOfCharSeriesTest01(){
        result = new ArrayList<>(Arrays.asList('1','.','1','1'));
        Assert.assertEquals(0.11d, Number.extractFractionPartOfCharSeries(result),0.d);
    }

    @Test
    public void extractFractionPartOfCharSeriesTest02(){
        result = new ArrayList<>(Arrays.asList('0','.','0','7'));
        Assert.assertEquals(0.07d, Number.extractFractionPartOfCharSeries(result), 0.d);
    }
}
