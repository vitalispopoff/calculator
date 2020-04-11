package calculation.calculations;

import calculation.Calculation;
import calculation.NodeType;

public class Calculation_Addition extends Calculation {

    static NodeType classType = NodeType.ADD_SUB;

    public Calculation_Addition() {
        super();
    }

    @Override
    public void setType() {
        this.type = classType;
    }

    @Override
    public double calculate(double left, double rite) {
        return left + rite;
    }


}