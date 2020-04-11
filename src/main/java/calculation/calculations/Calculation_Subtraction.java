package calculation.calculations;

import calculation.Calculation;
import calculation.NodeType;

public class Calculation_Subtraction extends Calculation {

    static NodeType classType = NodeType.ADD_SUB;

    public Calculation_Subtraction() {
        super();
    }

    public void setType() {
        this.type = classType;
    }

    @Override
    public double calculate(double left, double rite) {
        return left - rite;
    }
}
