// package;

import org.junit.*;

public class AlgebraicOperationalTest {

    @Test
    public void addTest01() {
        Number expected = new Number("0.");
        Number augend = new Number(".0");
        Number addend = new Number("1.0");
        Number result = AlgebraicOperational.add(augend, addend);
        Assert.assertEquals(expected.getValue(), result.getValue(), 0.d);
    }

//    TODO subtractTest
    @Ignore
    @Test
    public void subtractTest01(){}

//    TODO multiplyTest
    @Ignore
    @Test
    public void multiplyTest01(){}

//    TODO divideTest
    @Ignore
    @Test
    public void divideTest01(){}
}
