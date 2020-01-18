package calc;// package;

import calc.Number;
import org.junit.*;

public class NumberUnitTest {

    Number number;
    Number test;

    @Test
    public void numberTest01() {
        number = new Number("1.1");
        test = new Number();
        Assert.assertEquals(test.getClass(), number.getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void numberTest02() {
        new Number("1..1");
    }

    @Test
    public void valueToStringTest01() {
        Assert.assertEquals("271.15", Number.valueToString(271.15d));
    }

    @Test
    public void valueToStringOverloadedTest01(){

        Assert.assertEquals("271.15", new Number("271.15").valueToString());
    }
}
