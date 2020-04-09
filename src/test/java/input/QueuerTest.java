package input;

import org.junit.Assert;
import org.junit.Test;

public class QueuerTest {

    @Test
    public void Queuer_01(){
        Queuer q1 = new Queuer();
        Assert.assertNull(q1.prev);
        Assert.assertNull(q1.next);
        Assert.assertNull(q1.node);
    }

    @Test
    public void Queuer_02(){
        Queuer q0 = new Queuer();
        Queuer q1 = new Queuer(q0, null);
        Assert.assertSame(q0, q1.prev);
        Assert.assertNull(q1.next);
        Assert.assertNull(q1.node);
    }

    @Test
    public void Queuer_03(){
        Queuer q0 = new Queuer();
        Queuer q1 = new Queuer(q0, null);
        Assert.assertSame(q0, q1.prev);
        Assert.assertNull(q1.next);
        Assert.assertNull(q1.node);
    }

    @Test
    public void setPrev_01(){
        Queuer q0 = new Queuer();
        Queuer q1 = new Queuer();
        q1.setPrev(q0);
        Assert.assertSame(q0, q1.prev);
        Assert.assertSame(q1, q0.next);
    }

    @Test
    public void setNext_01(){
        Queuer q0 = new Queuer();
        Queuer q1 = new Queuer();
        q0.setNext(q1);
        Assert.assertSame(q1, q0.next);
        Assert.assertSame(q0, q1.prev);
    }
}