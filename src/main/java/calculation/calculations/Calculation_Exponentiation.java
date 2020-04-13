package calculation.calculations;

import calculation.Calculation;
import calculation.NodeType;

public class Calculation_Exponentiation extends Calculation {

    static NodeType classType = NodeType.EXP_ROOT;

    public Calculation_Exponentiation() {
        super();
    }

    public void setType() {
        this.type = classType;
    }

    @Override
    public double calculate(double left, double rite) {
        resetType();
        return Math.pow(left, rite);
    }
}
