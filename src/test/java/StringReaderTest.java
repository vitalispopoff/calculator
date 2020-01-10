

import org.junit.*;

public class StringReaderTest {

    @Test
    public void isInt01(){
        Assert.assertTrue(StringReader.isInt('1'));
    }

    @Test
    public void isInt02(){
        Assert.assertFalse(StringReader.isInt('/'));
    }

    @Test
    public void isInt03(){
        Assert.assertFalse(StringReader.isInt(':'));
    }

    @Test
    public void toIntTest01(){
        Assert.assertEquals(0, StringReader.toInt('0'));
    }

    @Test
    public void isRadixPointTest01(){
        Assert.assertTrue(StringReader.isRadixPoint('.'));
    }

    @Test
    public void isRadixPointTest02(){
        Assert.assertFalse(StringReader.isRadixPoint(','));
    }

    @Test
    public void toIntTest02(){
        Assert.assertEquals(1, StringReader.toInt('1'));
    }

    @Test
    public void isBracketTest01(){
        Assert.assertTrue(StringReader.isBracket('('));
    }

    @Test
    public void isBracketTest02(){
        Assert.assertTrue(StringReader.isBracket('('));
    }

    @Test
    public void isBracketTest03(){
        Assert.assertFalse(StringReader.isBracket('*'));
    }

    @Test
    public void isAlgebraicOperatorTest01(){
        Assert.assertTrue(StringReader.isAlgebraicOperator('+'));
    }

    @Test
    public void isAlgebraicOperatorTest02(){
        Assert.assertTrue(StringReader.isAlgebraicOperator('-'));
    }

    @Test
    public void isEquationOperatorTest01(){
        Assert.assertTrue(StringReader.isEquationOperator('='));
    }

    @Test
    public void isEquationOperatorTest02(){
        Assert.assertFalse(StringReader.isEquationOperator('1'));
    }


}
