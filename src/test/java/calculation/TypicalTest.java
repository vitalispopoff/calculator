package calculation;

import static gui.Settings.basicCalculator;
import static memory.Memory.*;
import static calculation.NodeType.*;
import static calculation.Typical.interact;

import input.*;
import memory.Memory;
import org.junit.*;

public class TypicalTest {

    static Typical
            type;

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

    private void pushTheButton(int buttonIndex){
        basicCalculator[buttonIndex].getType().interact(basicCalculator[buttonIndex]);
    }

    private void buttonSequencing(int[] sequence) {
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

    void static_interact_init() {
        int[] sequence = {12, 16, 18, 17, 12};
        buttonSequencing(sequence);
    }

    void static_interact_init_1() {
        int[] sequence = {12, 18, 17, 12};
        buttonSequencing(sequence);
    }

    @Ignore
    @Test
    public void static_interact_01() {
        Assert.assertEquals(0, Memory.parserCache.length());
        static_interact_init();
        Assert.assertEquals(4, Memory.parserCache.length());
        Assert.assertTrue(Memory.isParserCacheAValue());
    }

    @Ignore
    @Test
    public void static_interact_02() {
        static_interact_init();
        pushTheButton(11);
        Assert.assertEquals(VALUE, ((Enqueued) Memory.mainQueue.getHead()).getType());
        Assert.assertEquals(-1.01, ((Enqueued) Memory.mainQueue.getHead()).getNode().getValue(), 0.);
        Assert.assertEquals(ADD, ((Enqueued) Memory.mainQueue.getTail()).getType());
    }

    @Ignore
    @Test
    public void static_interact_03() {
        static_interact_init();
        pushTheButton(15);
        static_interact_init();
        pushTheButton(19);
        Assert.assertEquals(SUBTRACT, ((Enqueued) Memory.mainQueue.getHead()).getType());
        Assert.assertEquals(
                ((Enqueued) Memory.mainQueue.getHead()).getType(),
                ((Enqueued) Memory.mainQueue.getTail()).getType()
        );
    }

    @Ignore
    @Test
    public void static_interact_04() {
        static_interact_init_1();
        Assert.assertTrue(Memory.parserCache.length() > 0);
        pushTheButton(15);
        Assert.assertEquals(0, Memory.parserCache.length());
        Assert.assertEquals(VALUE, ((Enqueued) Memory.mainQueue.getHead()).getType());
        Assert.assertEquals(1.01, ((Enqueued) Memory.mainQueue.getHead()).getNode().getValue(), 0.);
        static_interact_init_1();
        pushTheButton(19);
        Nodeable cache = ((Enqueued) Memory.mainQueue.getHead()).getNode();
        Assert.assertEquals(1.01, cache.getLocalLeft().getValue(), 0.);
        Assert.assertEquals(1.01, cache.getLocalRite().getValue(), 0.);
        Assert.assertEquals(0., cache.getValue(), 0.);
    }

}