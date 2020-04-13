package calculation.calculations;

import calculation.Calculation;
import calculation.NodeType;

public class Calculation_Rooting extends Calculation {

    static NodeType classType = NodeType.EXP_ROOT;

    public Calculation_Rooting() {
        super();
    }

    public void setType() {
        this.type = classType;
    }

    @Override
    public double calculate(double left, double rite) {
        resetType();
        return Math.pow(left, 1. / rite);
    }
}
