package _temp.calculation.calculations;

import _temp.calculation.Calculation;
import _temp.calculation.NodeType;

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
        resetType();
        System.out.println(classType);
        return left + rite;
    }
}