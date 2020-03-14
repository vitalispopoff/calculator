import org.junit.*;


public class ParsableTest {


    @Test
    public void resetParsed_01() {
        Parsable.parsed = "0";
        Parsable.resetParsed();
        Assert.assertEquals(0, Parsable.parsed.length());
        Assert.assertEquals("", Parsable.parsed);
    }

    @Test
    public void NumberFromStreamTest() {
        String[] data = {"*1.01-2.11"};
        double[] answer = {1.0, 1.01, 4.0, 2.11};
        for (int i = 0; i < data[0].length(); i++) {
            Parsable.streamAssembler(data[0].charAt(i));
        }
        int j = Parsable.parsableDepot.size() - 1;
        Assert.assertEquals(answer[j], Parsable.parsableDepot.get(j).getTemporalValue(), 0.);
    }

    @Test
    public void Test_streamToValue_01() {
        Assert.assertEquals(0.1, Parsable.streamToValue(".1"), .0d);
    }

    @Test
    public void Test_streamToValue_02() {
        Assert.assertEquals(-1., Parsable.streamToValue("-1"), 0.d);
    }

    @Test
    public void streamAssembler_01() {
        Parsable.resetParsed();
        Parsable.streamAssembler('0');
        Assert.assertEquals("0", Parsable.parsed);
    }

    @Test
    public void streamAssembler_02(){
        Parsable.resetParsed();
        Parsable.streamAssembler('a');
        Assert.assertEquals("", Parsable.parsed);
    }

    @Test
    public void streamAssembler_03(){
        Parsable.resetParsed();
        Parsable.streamAssembler('+');
        Assert.assertEquals("", Parsable.parsed);
    }
}