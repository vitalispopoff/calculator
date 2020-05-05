package calculation;

import static memory.Memory.*;
import static calculation.NodeType.*;
import static gui.Settings.basicCalculator;

import input.*;
import memory.Memory;
import org.junit.*;

public class TypicalTest {

    static Typical
            type;
    static int[]
            seq0 = {12, 16, 18, 17, 12},    // "-1.01"
            seq1 = {12, 18, 17, 12};        // "1.01"
    double[]
            seqVal = {-1.01, 1.01};

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Before
    public void initial() {
        mainQueue = new NodeQueue(null);
        Memory.reset();
        type = VALUE;
    }

    @After
    public void terminal() {
        type = null;
    }

    private void pushTheButton(int buttonIndex) {
        basicCalculator[buttonIndex].getType().interact(basicCalculator[buttonIndex]);
    }

    private void buttonCombo(int[] sequence) {
        for (int buttonIndex : sequence) {
            pushTheButton(buttonIndex);
        }
    }

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Test
    public void getTypePriority_01() {
        int result = ((NodeType) type).ordinal() >> 1;
        Assert.assertEquals(result, type.getTypePriority());
    }

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Test
    public void interact_01() {
        Assert.assertEquals(0, Memory.parserCache.length());
        buttonCombo(seq0);
        Assert.assertEquals(4, Memory.parserCache.length());
        Assert.assertTrue(Memory.isParserCacheAValue());
    }

    @Test
    public void interact_02() {
        Assert.assertEquals(0, Memory.parserCache.length());
        buttonCombo(seq1);
        Assert.assertEquals(4, Memory.parserCache.length());
        Assert.assertTrue(Memory.isParserCacheAValue());
    }

    @Test
    public void static_interact_03() {
        buttonCombo(seq0);
        pushTheButton(11);
        Assert.assertEquals(VALUE, ((Enqueued) Memory.mainQueue.getHead()).getType());
        Assert.assertEquals(seqVal[0], ((Enqueued) Memory.mainQueue.getHead()).getNode().getValue(), 0.);
        Assert.assertEquals(ADD, ((Enqueued) Memory.mainQueue.getTail()).getType());
    }

    @Test
    public void static_interact_04() {
        buttonCombo(seq0);
        pushTheButton(15);
        buttonCombo(seq0);
        pushTheButton(19);
        Assert.assertEquals(SUBTRACT, ((Enqueued) Memory.mainQueue.getHead()).getType());
        Assert.assertEquals(
                ((Enqueued) Memory.mainQueue.getHead()).getType(),
                ((Enqueued) Memory.mainQueue.getTail()).getType()
        );
    }

    @Test
    public void static_interact_05() {
        buttonCombo(seq1);
        Assert.assertTrue(Memory.parserCache.length() > 0);
        pushTheButton(15);
        Assert.assertEquals(0, Memory.parserCache.length());
        Assert.assertEquals(VALUE, ((Enqueued) Memory.mainQueue.getHead()).getType());
        Assert.assertEquals(seqVal[1], ((Enqueued) Memory.mainQueue.getHead()).getNode().getValue(), 0.);
        buttonCombo(seq1);
        pushTheButton(19);
        Nodeable cache = ((Enqueued) Memory.mainQueue.getHead()).getNode();
        Assert.assertEquals(seqVal[1], cache.getLocalLeft().getValue(), 0.);
        Assert.assertEquals(seqVal[1], cache.getLocalRite().getValue(), 0.);
        Assert.assertEquals(0., cache.getValue(), 0.);
    }

}