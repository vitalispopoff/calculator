package _temp.calculation.calculations;

import _temp.calculation.Calculation;
import _temp.calculation.NodeType;

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
        System.out.println(classType);
        return Math.pow(left, rite);
    }
}