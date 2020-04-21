package input;

import calculation.*;

public class CalculationQueue extends Queuer implements Queuing{

    int[] queuerNodeTypes;
    int length = 0;

    public CalculationQueue(Queueable queuer) {
        setQueuerNodeTypes();
        prevOne = postOne = queuer;
        length++;
    }

    public void setQueuerNodeTypes() {
        this.queuerNodeTypes = new int[NodeType.values().length];
    }

    @Override public void addToQueue(Queueable queuer) {
    }
    @Override public Queueable takeFromQueue() {
        return null;
    }
}