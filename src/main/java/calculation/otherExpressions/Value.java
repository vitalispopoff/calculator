package calculation.otherExpressions;

import calculation.*;
import gui.Button;

public class Value extends Node {

    public Value(Typical type, Double value){
        super(type);
        this.value = value;
    }
    public Value(Button button){super(button);}

    public Value(Typical type) {
        super(type);
    }

    @Override
    protected Double calculate(Nodeable localLeft, Nodeable localRite) {
        return value;
    }
}