package calculation;

import calculation.otherExpressions.Value;
import org.junit.*;

public class NodeableTest {

    static Typical
            typVal = NodeType.VALUE,
            typ2 = NodeType.BRACKET_IN;
    static Nodeable
            node;

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Before
    public void initial() {
        node = new Value(typVal);
    }

    @After
    public void terminal() {
        node = null;
    }

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Test
    public void setLocalRite_NotNull() {
        Assert.assertNull(node.getLocalRite());
        node.setLocalRite(node);
        Assert.assertSame(node, node.getLocalRite());
    }

    @Test
    public void setLocalRoot_NotNull() {
        Assert.assertNull(node.getLocalRoot());
        node.setLocalRoot(node);
        Assert.assertSame(node, node.getLocalRoot());
    }

    @Test
    public void setLocalLeft_01() {
        Assert.assertNull(node.getLocalLeft());
        node.setLocalLeft(node);
        Assert.assertSame(node, node.getLocalLeft());
    }

    @Test
    public void setLocalType_01() {
        Assert.assertEquals(typVal, node.getType());
        node.setType(typ2);
        Assert.assertEquals(typ2, node.getType());
    }

    @Test
    public void getLocalRite_Null() {
        Assert.assertNull(node.getLocalRite());
    }

    @Test
    public void getLocalRoot_Null() {
        Assert.assertNull(node.getLocalRoot());
    }

    @Test
    public void getLocalLeft_Null() {
        Assert.assertNull(node.getLocalLeft());
    }

    @Test
    public void getValue_NaN() {
        Assert.assertTrue(node.getValue().isNaN());
    }

    @Test
    public void getType_01() {
        Assert.assertEquals(typVal, node.getType());
    }
}