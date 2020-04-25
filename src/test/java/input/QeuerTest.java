package input;

import calculation.*;
import calculation.calculations.Calculation_Exponentiation;
import org.junit.Test;

public class QeuerTest {

    static Typical
            typ1 = NodeType.VALUE,
            typ2 = NodeType.EXPONENT;
    static Nodeable
            node1 = new Value(typ1),
            node2 = new Calculation_Exponentiation(typ2);
    static int
            ord1,
            ord2;


    @Test
    public void Queuer_00() {

    }
}