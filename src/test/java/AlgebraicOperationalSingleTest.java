// package

import org.junit.*;

public class AlgebraicOperationalSingleTest {

    @Test
    public void addTest01() {Assert.assertEquals(0, new AlgebraicOperations(0, 0).add());}

    @Test
    public void addTest02() {Assert.assertEquals(1, new AlgebraicOperations(0, 1).add());}

    @Test
    public void addTest03() {Assert.assertEquals(1, new AlgebraicOperations(2, -1).add());}

    @Test
    public void subtractTest01() {Assert.assertEquals(0, new AlgebraicOperations(0, 0).subtract());}

    @Test
    public void subtractTest02() {Assert.assertEquals(0, new AlgebraicOperations(1, 1).subtract());}

    @Test
    public void subtractTest03() {Assert.assertEquals(2, new AlgebraicOperations(1, -1).subtract());}

    @Test
    public void multiplyTest01() {Assert.assertEquals(0, new AlgebraicOperations(0, 1).multiply());}

    @Test
    public void multiplyTest02() {Assert.assertEquals(1, new AlgebraicOperations(1, 1).multiply());}

    @Test
    public void multiplyTest03() {Assert.assertEquals(2, new AlgebraicOperations(1, 2).multiply());}

    @Test
    public void divideTest01() {Assert.assertEquals(0, new AlgebraicOperations(0, 1).divide());}

    @Test
    public void divideTest02() {Assert.assertEquals(3, new AlgebraicOperations(10, 3).divide());}

    @Test(expected = IllegalArgumentException.class)
    public void divideTest03() {new AlgebraicOperations(1, 0).divide();}
}

