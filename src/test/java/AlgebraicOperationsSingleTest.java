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
    public void subtractTest01() {
        Assert.assertEquals(0, AlgebraicOperations.subtract(0, 0));
    }

    @Test
    public void subtractTest02(){
        Assert.assertEquals(0, AlgebraicOperations.subtract(1, 1));
    }

    @Test
    public void subtractTest03(){
        Assert.assertEquals(2, AlgebraicOperations.subtract(1, -1));
    }

    @Test
    public void multiplyTest01(){
        Assert.assertEquals(0, AlgebraicOperations.multiply(0, 1));
    }

    @Test
    public void multiplyTest02(){
        Assert.assertEquals(1, AlgebraicOperations.multiply(1, 1));
    }

    @Test
    public void multiplyTest03(){
        Assert.assertEquals(2, AlgebraicOperations.multiply(1, 2));
    }

    @Test
    public void divideTest01(){
        Assert.assertEquals(0, AlgebraicOperations.divide(0,1));
    }

    @Test
    public void divideTest02(){
        Assert.assertEquals(3, AlgebraicOperations.divide(10,3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void divideTest03(){
        AlgebraicOperations.divide(1, 0);
    }
}

