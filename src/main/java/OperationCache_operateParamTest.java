import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class OperationCache_operateParamTest {

    @Parameterized.Parameters
    public static Collection createTestData(){
        Object[][] data = new Object[][]{
                {"0.02*5.", "0.1"},
                {"1.2+2.1","3.0"},
                {"1.-1.0","0.0"},
                {"2.5/0.5","5.0"},
        };
        return Arrays.asList(data);
    }

    String operationStream;
    String result;

    public OperationCache_operateParamTest(String result, String operationStream){
        this.operationStream = operationStream;
        this.result = result;
    }

    @Test
    public void operateParamTest(){
        Assert.assertEquals(result, OperationCache.operate(operationStream));
    }

}
