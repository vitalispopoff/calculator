import org.junit.*;

public class InputDataParserTest {

    @Test
    public void resetParsed_01() {
        InputDataParser.parsed = "0";
        InputDataParser.resetParsed();
        Assert.assertEquals(0, InputDataParser.parsed.length());
        Assert.assertEquals("", InputDataParser.parsed);
    }

    @Test
    public void streamToValue_01() {
        Assert.assertEquals(0.1, InputDataParser.streamToValue(".1"), .0d);
    }

    @Test
    public void streamToValue_02() {
        Assert.assertEquals(-1., InputDataParser.streamToValue("-1"), 0.d);
    }

    @Test
    public void streamAssembler_00() {
        String[] data = {"*1.01-2.11"};
        double[] answer = {1.0, 1.01, 4.0, 2.11};
        for (int i = 0; i < data[0].length(); i++) {
            InputDataParser.streamAssembler(data[0].charAt(i));
        }
        int j = InputDataParser.inputDataParserDepot.size() - 1;
        Assert.assertEquals(answer[j], InputDataParser.inputDataParserDepot.get(j).getTemporalValue(), 0.);
    }

    @Test
    public void streamAssembler_01() {
        InputDataParser.resetParsed();
        InputDataParser.streamAssembler('0');
        Assert.assertEquals("0", InputDataParser.parsed);
    }

    @Test
    public void streamAssembler_02(){
        InputDataParser.resetParsed();
        InputDataParser.streamAssembler('a');
        Assert.assertEquals("", InputDataParser.parsed);
    }

    @Test
    public void streamAssembler_03(){
        InputDataParser.resetParsed();
        InputDataParser.streamAssembler('+');
        Assert.assertEquals("", InputDataParser.parsed);
    }
}