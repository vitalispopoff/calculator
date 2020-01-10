// package

import org.junit.*;

public class AlgebraicOperationsSingleTest {

    @Test
    public void addTest01() {
        Assert.assertEquals(0, AlgebraicOperations.add(0, 0));
    }
    @Test
    public void addTest02() {
        Assert.assertEquals(1, AlgebraicOperations.add(0, 1));
    }
    @Test
    public void addTest03() {
        Assert.assertEquals(1, AlgebraicOperations.add(2, -1));
    }

    @Test
    public void subtract01(){
        Assert.assertEquals(0, AlgebraicOperations.subtract(1, 1));
    }
}

