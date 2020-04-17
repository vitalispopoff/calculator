package calculation.calculations;

import calculation.Calculation;
import calculation.NodeType;

public class Calculation_Rooting extends Calculation {

    public Calculation_Rooting(NodeType type){
        super(type);
    }

    @Override
    protected double perform(double left, double rite) {
        return Math.pow(left, 1. / rite);
    }
}