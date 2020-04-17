package calculation.calculations;

import calculation.Calculation;
import calculation.NodeType;

public class Calculation_Exponentiation extends Calculation {

    public Calculation_Exponentiation(NodeType type){
        super(type);
    }

    @Override
    protected double perform(double left, double rite) {
        return Math.pow(left, rite);
    }
}