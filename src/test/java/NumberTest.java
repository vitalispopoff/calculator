// package;

import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberTest {

//    @Ignore
    @Test
    public void convertToNumberTest01(){
        Assert.assertEquals(1.1d, Number.convertToNumber("1.1"), 0.0);
    }

    @Test
    public void sliceToSeriesTest01(){
        List<Character> result = new ArrayList<Character>(Arrays.asList('1','.','1'));
        Assert.assertEquals(result, Number.sliceToSeries("1.1"));
    }

    @Test
    public void sliceToSeriesTest02(){
        List<Character> result = new ArrayList<Character>(Arrays.asList('1','a','.','1'));
        Assert.assertEquals(result, Number.sliceToSeries("1a.1"));
    }

    @Test
    public void isSeriesProperNumberTest01(){
        Assert.assertTrue(Number.isSeriesProperNumber(Number.sliceToSeries("1.1")));
    }

    @Test
    public void isSeriesProperNumberTest02(){
        Assert.assertFalse(Number.isSeriesProperNumber(Number.sliceToSeries("1..1")));
    }

    @Test
    public void isSeriesProperNumberTest03(){
        Assert.assertFalse(Number.isSeriesProperNumber(Number.sliceToSeries(".")));
    }

//  TODO change to assertEquals
    @Test
    public void isSeriesProperNumberTest04(){
        Assert.assertTrue(Number.isSeriesProperNumber(Number.sliceToSeries("-1.1")));
    }


    @Test
    public void extractIntegerPartOfCharSeriesTest01(){
        List<Character> result = new ArrayList<Character>(Arrays.asList('1','1','.','1'));
        Assert.assertEquals(11.d, Number.extractIntegerPartOfCharSeries(result),0.d);
    }

    @Test
    public void extractFractionPartOfCharSeriesTest01(){
        List<Character> result = new ArrayList<Character>(Arrays.asList('1','.','1','1'));
        Assert.assertEquals(0.11d, Number.extractFractionPartOfCharSeries(result),0.d);
    }

    @Test
    public void extractFractionPartOfCharSeriesTest02(){
        List<Character> result = new ArrayList<Character>(Arrays.asList('0','.','0','7'));
        Assert.assertEquals(0.07d, Number.extractFractionPartOfCharSeries(result), 0.d);
    }




}
