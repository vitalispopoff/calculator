// package;

import org.junit.*;

public class AlgebraicOperationalTest {

    @Test
    public void addTest01() {
        Number expected = new Number("1.");
        Number augend = new Number(".0");
        Number addend = new Number("1.0");
        Number result = AlgebraicOperational.add(augend, addend);
        Assert.assertEquals(expected.getValue(), result.getValue(), 0.d);
    }

    @Test
    public void subtractTest01(){
        Number expected = new Number("1.");
        Number minuend = new Number("3.0");
        Number subtrahent = new Number("2.0");
        Number result = AlgebraicOperational.subtract(minuend, subtrahent);
        Assert.assertEquals(expected.getValue(), result.getValue(), 0.d);
    }

    @Test
    public void multiplyTest01(){
        Number expected = new Number("12.");
        Number multiplier = new Number("3.0");
        Number multiplicant = new Number("4.0");
        Number result = AlgebraicOperational.multiply(multiplier, multiplicant);
        Assert.assertEquals(expected.getValue(), result.getValue(), 0.d);
    }

//    TODO divideTest
    @Ignore
    @Test
    public void divideTest01(){}
}
