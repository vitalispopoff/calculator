package calc;//  package;

import calc.InputDataStreamReading;
import org.junit.*;

public class InputDataStreamReadingUnitTest {

    @Test
    public void isInt01(){
        Assert.assertTrue(InputDataStreamReading.isInt('1'));
    }

    @Test
    public void isInt02(){
        Assert.assertFalse(InputDataStreamReading.isInt('/'));
    }

    @Test
    public void isInt03(){
        Assert.assertFalse(InputDataStreamReading.isInt(':'));
    }

    @Test
    public void toIntTest01(){
        Assert.assertEquals(0, InputDataStreamReading.toInt('0'));
    }

    @Test
    public void isRadixPointTest01(){
        Assert.assertTrue(InputDataStreamReading.isRadixPoint('.'));
    }

    @Test
    public void isRadixPointTest02(){
        Assert.assertFalse(InputDataStreamReading.isRadixPoint(','));
    }

    @Test
    public void toIntTest02(){
        Assert.assertEquals(1, InputDataStreamReading.toInt('1'));
    }

    @Test
    public void isBracketTest01(){
        Assert.assertTrue(InputDataStreamReading.isBracket('('));
    }

    @Test
    public void isBracketTest02(){
        Assert.assertTrue(InputDataStreamReading.isBracket('('));
    }

    @Test
    public void isBracketTest03(){
        Assert.assertFalse(InputDataStreamReading.isBracket('*'));
    }

    @Test
    public void isAlgebraicOperatorTest01(){
        Assert.assertTrue(InputDataStreamReading.isAlgebraicOperator('+'));
    }

    @Test
    public void isAlgebraicOperatorTest02(){
        Assert.assertTrue(InputDataStreamReading.isAlgebraicOperator('-'));
    }

    @Test
    public void isEquationOperatorTest01(){
        Assert.assertTrue(InputDataStreamReading.isEquationOperator('='));
    }

    @Test
    public void isEquationOperatorTest02(){
        Assert.assertFalse(InputDataStreamReading.isEquationOperator('1'));
    }

    @Test
    public void fromIntTest01(){
        Assert.assertEquals('0', InputDataStreamReading.fromInt(0));
    }
}
