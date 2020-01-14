// package

import org.junit.*;

public class AlgebraicOperationsUnitTest {

    @Test
    public void addTest01() {Assert.assertEquals(0, new AlgebraicOperations(0, 0).addition());}

    @Test
    public void addTest02() {Assert.assertEquals(1, new AlgebraicOperations(0, 1).addition());}

    @Test
    public void addTest03() {Assert.assertEquals(1, new AlgebraicOperations(2, -1).addition());}

    @Test
    public void subtractTest01() {Assert.assertEquals(0, new AlgebraicOperations(0, 0).subtraction());}

    @Test
    public void subtractTest02() {Assert.assertEquals(0, new AlgebraicOperations(1, 1).subtraction());}

    @Test
    public void subtractTest03() {Assert.assertEquals(2, new AlgebraicOperations(1, -1).subtraction());}

    @Test
    public void multiplyTest01() {Assert.assertEquals(0, new AlgebraicOperations(0, 1).multiplication());}

    @Test
    public void multiplyTest02() {Assert.assertEquals(1, new AlgebraicOperations(1, 1).multiplication());}

    @Test
    public void multiplyTest03() {Assert.assertEquals(2, new AlgebraicOperations(1, 2).multiplication());}

    @Test
    public void divideTest01() {Assert.assertEquals(0, new AlgebraicOperations(0, 1).division());}

    @Test
    public void divideTest02() {Assert.assertEquals(3, new AlgebraicOperations(10, 3).division());}

    @Test(expected = IllegalArgumentException.class)
    public void divideTest03() {new AlgebraicOperations(1, 0).division();}
}

