package input;

import calculation.*;

public class NodeQueue extends Queuer implements Queuing {

    int[] queuerNodeTypes;
    int length = 0;

    public NodeQueue(Queueable queuer) {
        setQueuerNodeTypes();
        prevOne = postOne = queuer;
        length++;
    }

    public void setQueuerNodeTypes() {
        this.queuerNodeTypes = new int[NodeType.values().length];
    }

//    @formatter:off

    @Override public void addToQueue(Queueable queuer) { }
    @Override public Queueable takeFromQueue() {
        return null;
    }

//    @formatter:on
}