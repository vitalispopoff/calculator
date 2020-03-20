package _temp;

import org.junit.*;

@Ignore
public class CharIdentificationTest {

    @Test
    public void whatType_01() {
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
    public void isInt_01() {
        Assert.assertTrue(CharIdentification.isInt('1'));
    }

    @Test
    public void isInt_02() {
        Assert.assertFalse(CharIdentification.isInt('/'));
    }

    @Test
    public void isInt_03() {
        Assert.assertFalse(CharIdentification.isInt(':'));
    }


    @Test
    public void toIntTest_01() {
        Assert.assertEquals(0, CharIdentification.toInt('0'));
    }


    @Test
    public void isRadixPoint_01() {
        Assert.assertTrue(CharIdentification.isRadixPoint('.'));
    }

    @Test
    public void isRadixPoint_02() {
        Assert.assertFalse(CharIdentification.isRadixPoint(','));
    }


    @Test
    public void toInt_02() {
        Assert.assertEquals(1, CharIdentification.toInt('1'));
    }


    @Test
    public void isAlgebraicOperator_01() {
        Assert.assertTrue(CharIdentification.isAlgebraicOperator('+'));
    }

    @Test
    public void isAlgebraicOperator_02() {
        Assert.assertTrue(CharIdentification.isAlgebraicOperator('-'));
    }


    @Test
    public void toAlgebraicOperator_01(){
        Assert.assertEquals(1, CharIdentification.toAlgebraicOperator('*'));
        Assert.assertEquals(2, CharIdentification.toAlgebraicOperator('+'));
        Assert.assertEquals(3, CharIdentification.toAlgebraicOperator('-'));
        Assert.assertEquals(4,CharIdentification.toAlgebraicOperator('/'));
    }



    @Test
    public void isEquationOperator_01() {
        Assert.assertTrue(CharIdentification.isEquationOperator('='));
    }

    @Test
    public void isEquationOperator_02() {
        Assert.assertFalse(CharIdentification.isEquationOperator('1'));
    }


    @Test
    public void fromInt_01() {
        Assert.assertEquals('0', CharIdentification.fromInt(0));
    }
}
