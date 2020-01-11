// package;

import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberTest {

//    @Ignore
//    @Test
    public void convertToNumberTest01(){
        Assert.assertEquals(1.1f, Number.convertToNumber("1.1"));
    }

    @Test
    public void  sliceToSeriesTest01(){
        List<Character> result = new ArrayList<Character>(Arrays.asList('1','.','1'));
        Assert.assertEquals(result, Number.sliceToSeries("1.1"));
    }
}
