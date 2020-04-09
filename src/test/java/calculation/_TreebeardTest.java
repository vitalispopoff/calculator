package calculation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static calculation.Treebeard.*;

public class _TreebeardTest {

    @Before
    public void resetSlots() {
        leftSlot = rootSlot = riteSlot = null;
        leftNull = rootNull = riteNull = true;
    }

    @Test
    public void setLeftNull_01() {
        Assert.assertTrue(setLeftNull());
        leftSlot = new Value();
        Assert.assertFalse(setLeftNull());
    }

    @Test
    public void setRootNull_01() {
        Assert.assertTrue(setRootNull());
        rootSlot = new Calculation_Addition(null, null);
        Assert.assertFalse(setRootNull());
    }

    @Test
    public void setRiteNull_01() {
        Assert.assertTrue(setRiteNull());
        riteSlot = new Value();
        Assert.assertFalse(setRiteNull());
    }

    @Test
    public void identifySlot_01() {
        Assert.assertEquals(0, identifySlot());
    }

    @Test
    public void identifySlot_02() {
        Assert.assertEquals(0, identifySlot());

        Node n1 = new Value();
        setLeftSlot(n1);
        Assert.assertEquals(1, identifySlot());

        Node n2 = new Calculation_Addition(n1, null);
        setRootSlot(n2);
        Assert.assertEquals(2, identifySlot());

        Node n3 = new Value();
        setRiteSlot(n3);
        Assert.assertNotNull(riteSlot);
        Assert.assertFalse(riteNull);
    }
}