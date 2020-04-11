package _temp;

import calculation.Node;
import calculation.calculations.Calculation_Addition;
import org.junit.*;

@Ignore
public class _CalculationAdditionTest {

    @Test
    public void Calculation_Addition_00() {
        Node n = new Calculation_Addition();
        Assert.assertTrue(n instanceof Calculation_Addition);
    }
}
