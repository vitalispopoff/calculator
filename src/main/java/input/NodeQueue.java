package input;

import calculation.NodeType;

class NodeQueue extends QueueCore implements Queuing {

    int[] nodeCounter = new int[NodeType.values().length];
    int queuerCounter = 0;

    NodeQueue() {
        super();
    }

    @Override
    public void updateCounters(Queueable queuer) {
        nodeCounter[((Queuer) queuer).getTypeOrdinal()]++;
        queuerCounter++;
    }

    @Override
    public void updateCounters() {
        nodeCounter[((Queuer) head).getTypeOrdinal()]--;
        queuerCounter--;
    }
}