
import org.junit.*;

public class CharIdentificationTest {


    @Test
    public void whatType() {
        char[] data = {'0', '.', '+', '-', '*', '/', '(', ')', '%', 'a'};
        CharType[] answer = {
                CharType.INT,   // 0
                CharType.INT,   // .
                CharType.OPERATOR,   // +
                CharType.OPERATOR,   // -
                CharType.OPERATOR,   // *
                CharType.OPERATOR,   // /
                CharType.BRACKET_ON,   // (
                CharType.BRACKET_OFF,  // )
                CharType.UNSUPPORTED,   // %
                CharType.UNSUPPORTED,   // a
        };
        for (int i = 0; i < data.length; i++) {
            Assert.assertTrue(CharIdentification.whatType(data[i]) == answer[i]);
        }
    }

    @Test
    public void isInt01() {
        Assert.assertTrue(CharIdentification.isInt('1'));
    }

    @Test
    public void isInt02() {
        Assert.assertFalse(CharIdentification.isInt('/'));
    }

    @Test
    public void isInt03() {
        Assert.assertFalse(CharIdentification.isInt(':'));
    }

    @Test
    public void toIntTest01() {
        Assert.assertEquals(0, CharIdentification.toInt('0'));
    }

    @Test
    public void isRadixPointTest01() {
        Assert.assertTrue(CharIdentification.isRadixPoint('.'));
    }

    @Test
    public void isRadixPointTest02() {
        Assert.assertFalse(CharIdentification.isRadixPoint(','));
    }

    @Test
    public void toIntTest02() {
        Assert.assertEquals(1, CharIdentification.toInt('1'));
    }

/*
    @Test
    public void isBracketTest01(){
        Assert.assertTrue(CharIdentification.isBracket('('));
    }

    @Test
    public void isBracketTest02(){
        Assert.assertTrue(CharIdentification.isBracket('('));
    }

    @Test
    public void isBracketTest03(){
        Assert.assertFalse(CharIdentification.isBracket('*'));
    }
*/  // TODO disposable

    @Test
    public void isAlgebraicOperatorTest01() {
        Assert.assertTrue(CharIdentification.isAlgebraicOperator('+'));
    }

    @Test
    public void isAlgebraicOperatorTest02() {
        Assert.assertTrue(CharIdentification.isAlgebraicOperator('-'));
    }

    @Test
    public void isEquationOperatorTest01() {
        Assert.assertTrue(CharIdentification.isEquationOperator('='));
    }

    @Test
    public void isEquationOperatorTest02() {
        Assert.assertFalse(CharIdentification.isEquationOperator('1'));
    }

    @Test
    public void fromIntTest01() {
        Assert.assertEquals('0', CharIdentification.fromInt(0));
    }
}
