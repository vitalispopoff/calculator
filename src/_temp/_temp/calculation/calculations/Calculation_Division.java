package _temp.calculation.calculations;

import _temp.calculation.Calculation;
import _temp.calculation.NodeType;

public class Calculation_Division extends Calculation {

    static NodeType classType = NodeType.MULTI_DIV;

    public Calculation_Division() {
        super();
    }

    public void setType() {
        this.type = classType;
    }

    @Override
    public double calculate(double left, double rite) {
        resetType();
        System.out.println(classType);
        return left / rite;
    }
}