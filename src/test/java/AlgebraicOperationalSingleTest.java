// package

import org.junit.*;

public class AlgebraicOperationalSingleTest {

    AlgebraicOperational test;

    @Test
    public void addTest01() {
        test = new AlgebraicOperations(0, 0);
        Assert.assertEquals(0, test.add());
    }

    @Test
    public void addTest02() {
        test = new AlgebraicOperations(0, 1);
        Assert.assertEquals(1, test.add());
    }

    @Test
    public void addTest03() {
        test = new AlgebraicOperations(2, -1);
        Assert.assertEquals(1, test.add());
    }

    @Test
    public void subtractTest01() {
        test = new AlgebraicOperations(0, 0);
        Assert.assertEquals(0, test.subtract());
    }

    @Test
    public void subtractTest02() {
        test = new AlgebraicOperations(1, 1);
        Assert.assertEquals(0, test.subtract());
    }

    @Test
    public void subtractTest03() {
        test = new AlgebraicOperations(1, -1);
        Assert.assertEquals(2, test.subtract());
    }

    @Test
    public void multiplyTest01() {
        test = new AlgebraicOperations(0, 1);
        Assert.assertEquals(0, test.multiply());
    }

    @Test
    public void multiplyTest02() {
        test = new AlgebraicOperations(1, 1);
        Assert.assertEquals(1, test.multiply());
    }

    @Test
    public void multiplyTest03() {
        test = new AlgebraicOperations(1, 2);
        Assert.assertEquals(2, test.multiply());
    }

    @Test
    public void divideTest01() {
        test = new AlgebraicOperations(0, 1);
        Assert.assertEquals(0, test.divide());
    }

    @Test
    public void divideTest02() {
        test = new AlgebraicOperations(10, 3);
        Assert.assertEquals(3, test.divide());
    }

    @Test(expected = IllegalArgumentException.class)
    public void divideTest03() {
        test = new AlgebraicOperations(1, 0);
        test.divide();
    }
}

