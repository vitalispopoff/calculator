package calculation.calculations;

import calculation.Calculation;
import calculation.NodeType;
import calculation.Nodeable;

public class Calculation_Multiplication extends Calculation {

    public Calculation_Multiplication(NodeType type){
        super(type);
    }

    @Override
    protected double perform(double left, double rite) {
        return left * rite;
    }
}