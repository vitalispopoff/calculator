package calculation.calculations;

import calculation.Calculation;
import calculation.NodeType;

public class Calculation_Multiplication extends Calculation {

    public Calculation_Multiplication(NodeType type){
        super(type);
    }

    @Override
    protected double perform(double left, double rite) {
        return left * rite;
    }
}