package calc;//  package;

import calc.Number;
import calc.OperationCache;
import org.junit.*;

public class OperationCacheUnitTest {

    String test = "1.0*0.1";

    @Ignore
    @Test
    public void operateTest01() {
        /*Assert.assertEquals("0.1", OperationCache.operate(test));*/
    }

    @Test
    public void extractArgument1() {
        double result = new Number("1.0").getValue();
        Assert.assertEquals(
                result,
                OperationCache.extractArgument1(test).getValue(),
                0.0d
        );
    }

    @Test
    public void extractArgument2() {
        double result = new Number("0.1").getValue();
        Assert.assertEquals(
                result,
                OperationCache.extractArgument2(test).getValue(),
                0.0d
        );
    }

    @Test
    public void getOperatorIndexTest() {
        test = "1.0*-0.1";
        Assert.assertEquals(3, OperationCache.getOperatorIndex(test));
    }
}
