package calculation;

import input.*;
import memory.Memory;
import org.junit.*;

import static calculation.NodeType.*;
import static calculation.Typical.interact;
import static memory.Memory.mainQueue;

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

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Test
    public void getTypePriority_01() {
        int result = ((NodeType) type).ordinal() >> 1;
        Assert.assertEquals(result, type.getTypePriority());
    }

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    void static_interact_init() {
        interact(VALUE, '1');
        interact(SPIN, '∓');
        interact(VALUE, '.');
        interact(VALUE, '0');
        interact(VALUE, '1');
    }
    void static_interact_init_1() {
        interact(VALUE, '1');
        interact(VALUE, '.');
        interact(VALUE, '0');
        interact(VALUE, '1');
    }

    @Test
    public void static_interact_01() {
        Assert.assertEquals(0, Memory.parserCache.length());
        static_interact_init();
        Assert.assertEquals(4, Memory.parserCache.length());
        Assert.assertTrue(Memory.isParserCacheAValue());
    }

    @Test
    public void static_interact_02() {

    }

    @Test
    public void static_interact_03() {
        static_interact_init();
        interact(ADD, '+');
        Assert.assertEquals(VALUE, ((Enqueued) Memory.mainQueue.getHead()).getType());
        Assert.assertEquals(-1.01, ((Enqueued) Memory.mainQueue.getHead()).getNode().getValue(), 0.);
        Assert.assertEquals(ADD, ((Enqueued) Memory.mainQueue.getTail()).getType());
    }

    @Test
    public void static_interact_04() {
        static_interact_init();
        interact(SUBTRACT, '-');
        static_interact_init();
        interact(EVALUATE, '=');
        Assert.assertEquals(SUBTRACT, ((Enqueued) Memory.mainQueue.getHead()).getType());
        Assert.assertEquals(
                ((Enqueued) Memory.mainQueue.getHead()).getType(),
                ((Enqueued) Memory.mainQueue.getTail()).getType()
        );
    }

    @Test
    public void static_interact_05(){
        static_interact_init_1();
        Assert.assertTrue(Memory.parserCache.length()>0);
        interact(SUBTRACT, '-');
        Assert.assertEquals(0,Memory.parserCache.length());
        Assert.assertEquals(VALUE, ((Enqueued) Memory.mainQueue.getHead()).getType());
        Assert.assertEquals(1.01, ((Enqueued) Memory.mainQueue.getHead()).getNode().getValue(),0.);
        static_interact_init_1();
        interact(EVALUATE, '=');
        Nodeable cache = ((Enqueued) Memory.mainQueue.getHead()).getNode();
        Assert.assertEquals(1.01, cache.getLocalLeft().getValue(),0.);
        Assert.assertEquals(1.01, cache.getLocalRite().getValue(),0.);
        Assert.assertEquals(0., cache.getValue(),0.);
    }

}