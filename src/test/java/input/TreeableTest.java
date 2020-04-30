package input;

import calculation.*;
import org.junit.After;
import org.junit.Before;

public class TreeableTest {

    static Typical
            typ1 = NodeType.VALUE,
            typ2 = NodeType.EXPONENT,
            typ3 = NodeType.VALUE,
            typ4 = NodeType.ADD,
            typ5 = NodeType.VALUE;
    static int
            ord1 = typ1.ordinal(),
            ord2 = typ2.ordinal(),
            ord3 = typ3.ordinal(),
            ord4 = typ4.ordinal(),
            ord5 = typ5.ordinal();
    static Nodeable
            node1/* = typ1.interact()*/,
            node2/* = typ2.interact()*/,
            node3/* = typ3.interact()*/,
            node4/* = typ4.interact()*/,
            node5/* = typ5.interact()*/;
    static Enqueued
            que1/* = new Queuer(node1)*/,
            que2/* = new Queuer(node2)*/,
            que3/* = new Queuer(node3)*/,
            que4/* = new Queuer(node4)*/,
            que5/* = new Queuer(node5)*/;
    static Queuing
            Q1;

    @Before
    public void initial() {
        que1 = new Queuer(node1);
        que2 = new Queuer(node2);
        que3 = new Queuer(node3);
        que4 = new Queuer(node4);
        que5 = new Queuer(node5);
        Q1 = (Queuing) new NodeQueue(que1);
    }

    @After
    public void terminal() {
        que1 = que2 = que3 = que4 = que5 = null;
        Q1 = null;
    }
}
