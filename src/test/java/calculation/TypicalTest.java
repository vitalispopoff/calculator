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
        Assert.assertEquals(VALUE, ((Enqueued) mainQueue.getHead()).getType());
        Assert.assertEquals(seqVal[0], ((Enqueued) mainQueue.getHead()).getNode().getValue(), 0.);
        Assert.assertEquals(ADD, ((Enqueued) mainQueue.getTail()).getType());
    }

    @Ignore
    @Test
    public void static_interact_04() {
        buttonCombo(seq0);
        pushTheButton(15);
        buttonCombo(seq0);
        pushTheButton(19);
        Assert.assertEquals(VALUE, ((Enqueued) mainQueue.getHead()).getType());   // !
        Assert.assertEquals(
                ((Enqueued) mainQueue.getHead()).getType(),
                ((Enqueued) mainQueue.getTail()).getType()
        );
        double result = ((Enqueued) mainQueue .getHead()).getNode().getValue();
        Assert.assertEquals(0., result, 0.);
    }

    @Test
    public void interact_04_temp(){
        buttonCombo(seq0);
        pushTheButton(15);
        buttonCombo(seq0);
        Memory.dumpParserCache();
        mainQueue.convertToLocalTree(mainQueue.getHead());
        Assert.assertNotNull(mainQueue.getHead());
        Assert.assertSame(mainQueue.getHead(), mainQueue.getTail());

//        TODO check the left branch in the convertToLocalTree

    }

    @Ignore
    @Test
    public void static_interact_05() {
        buttonCombo(seq1);
        Assert.assertTrue(Memory.parserCache.length() > 0);

        pushTheButton(15);
        Assert.assertEquals(0, Memory.parserCache.length());
        Assert.assertEquals(VALUE, ((Enqueued) mainQueue.getHead()).getType());
        Assert.assertEquals(seqVal[1], ((Enqueued) mainQueue.getHead()).getNode().getValue(), 0.);

        buttonCombo(seq1);
        pushTheButton(19);

        Nodeable
                cache = ((Enqueued) mainQueue.getHead()).getNode();

        Assert.assertEquals(seqVal[1], cache.getLocalLeft().getValue(), 0.);    // !
        Assert.assertEquals(seqVal[1], cache.getLocalRite().getValue(), 0.);    // !
        Assert.assertEquals(0., cache.getValue(), 0.);                 // !
    }

    @Test   // * 1.01 - -1.01 *2
    public void static_interact_06() {
        buttonCombo(seq1);
        pushTheButton(15);
        buttonCombo(seq0);
        pushTheButton(7);
        pushTheButton(13);

        {
            Nodeable.dumpParserCache();
            Assert.assertEquals(seqVal[1], ((Enqueued) mainQueue.getHead()).getNode().getValue(), 0.);
            Assert.assertEquals(2., ((Enqueued) mainQueue.getTail()).getNode().getValue(), 0.);
        }   // checks the order fo the hitherto steps  - disposable


//        pushTheButton(19);
//        Assert.assertEquals(seqVal[1], ((Enqueued)mainQueue.getHead()).getNode().getValue(),0. );
    }

    @Test
    public void temporal_01() {
        int index = 19;
        Typical expectation = EVALUATE;
        Assert.assertEquals(expectation, basicCalculator[index].getType());

    }


}