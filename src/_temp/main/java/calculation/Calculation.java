package calculation;

import static memory.Memory.*;

import gui.Button;
import input.Queuer;

public abstract class Calculation extends Node {

    public Calculation() {
        super();
    }

    public Calculation(Typical type) {
        super(type);
    }

    public Calculation(Button button) {
        super(button);
        Nodeable.dumpParserCache();
        mainQueue.updateQueue(new Queuer(this));
    }

    @Override
    protected Double calculate(Nodeable localLeft, Nodeable localRite) {
        double
                leftValue = localLeft.getValue(),
                riteValue = localRite.getValue();
        return perform(leftValue, riteValue);
    }

    protected abstract double perform(double leftValue, double riteValue);


}