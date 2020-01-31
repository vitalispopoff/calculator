import org.junit.*;

public class ParsableTest {

//    @Ignore
    @Test
    public void NumberFromStreamTest(){
        String[] data = {"*1.01-2.11"};
        double[] answer = {1.0, 1.01, 4.0, 2.11};
        for (int i = 0; i < data[0].length(); i++) {
            Parsable.streamAssembler(data[0].charAt(i));
        }
        int j = Parsable.parsableDepot.size()-1;
        Assert.assertEquals(answer[j], Parsable.parsableDepot.get(j).getTemporalValue(), 0.);
    }



/*    @Test
    public void Test_streamAssembler_00() {
        Parsable.resetParsed();
        String argument = "0.0102";
        double[] result = {0.0, 0.0, 0.0, 0.01, 0.01, 0.0102};

        for (int i = 0; i < 6; i++) {
            Assert.assertEquals(result[i], Parsable.streamAssembler(argument.charAt(i)), 0.);
        }
    }*/

    @Test
    public void Test_streamToValue_01() {
        Assert.assertEquals(0.1, Parsable.streamToValue(".1"), .0d);
    }

    @Test
    public void Test_streamToValue_02() {
        Assert.assertEquals(-1., Parsable.streamToValue("-1"), 0.d);
    }



        /*
    @Test
    public void Test_valueToStream_00() {
        String[] result = {"0.0", "1.0", "0.012", "-0.1"};
        double[] argument = {0.0, 1.0, 0.012, -0.1};

        for (int i = 0; i < 4; i++) {
            Assert.assertEquals(result[i], Parsable.valueToStream(argument[i]));
        }
    }

    @Test
    public void Test_valueToStream_01() {
        Assert.assertEquals("1.0", Parsable.valueToStream(1.0d));
    }

    @Test
    public void Test_valueToStream_02() {
        Assert.assertEquals("1.0", Parsable.valueToStream(1.d));
    }

    @Test
    public void Test_valueToStream_03() {
        Assert.assertEquals("-0.1", Parsable.valueToStream(-.1d));
    }
*/  // ! probably disposable

}
