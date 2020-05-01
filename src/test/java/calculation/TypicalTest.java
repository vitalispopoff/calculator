package calculation;

import org.junit.*;

public class TypicalTest {

    static Typical
            type;

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Before
    public void setup_01(){
        type = NodeType.VALUE;
    }

    @After
    public void terminal(){
        type = null;
    }

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Test
    public void ordinal_01(){
        int result = ((NodeType)type).ordinal();
        Assert.assertEquals(result, type.ordinal());
    }   // !SSUE#12
}