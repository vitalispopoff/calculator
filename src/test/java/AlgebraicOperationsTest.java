import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AlgebraicOperationsTest {

    @Parameterized.Parameters
    public static Collection createDataTest(){
        Object[][] data = new Object[][]{
                {0, 0, 0},
                {1, 0, 1},
                {1, 1, 0},
                {0, 1, -1},
                {1, 2, -1},
                {1, -1, 2},
        };
        return Arrays.asList(data);
    }

    int a;
    int b;
    int result;


    public AlgebraicOperationsTest(int result, int a, int b) {
        this.a = a;
        this.b = b;
        this.result = result;
    }
    
    @Test
    public void addParameterizedTest(){
        Assert.assertEquals(result, AlgebraicOperations.add(a, b));
    }
    
    
/*    @Ignore
    @Test
    public void addSingleTest(){
        Assert.assertEquals(0, AlgebraicOperations.add(0, 0));
    }*/
}
