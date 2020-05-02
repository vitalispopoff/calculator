package input;

import calculation.*;

public class NodeQueue extends Queueability implements Queuing {

    public int[] nodeCounter = new int[NodeType.values().length];

    public NodeQueue(Queueable queueable) {
        head = tail = queueable;
        try {
            updateCounter(queueable);
        } catch (Exception ignored) {
        }
    }

    @Override
    public int currentPriorityIndex(){
        int index = 0;
        for (int i : nodeCounter) {
            if (i == 0) index++;
            else return index;
        }
        return index;
    }

    @Override
    public void updateCounter(Queueable queuer) {
        int index = ((Enqueued) queuer).getPriorityIndex();
        nodeCounter[index]++;
    }

    @Override
    public void updateCounter() {
        if (head != null) {
            int index = ((Enqueued) head).getPriorityIndex();
            if (nodeCounter[index] > 0) nodeCounter[index]--;
        }
    }

    @Override
    public int getCounter(Queueable queuer) {
        if (queuer == null) return 0;
        else {
            int index = ((Enqueued) queuer).getPriorityIndex();
            return nodeCounter[index];
        }
    }

    @Override
    public int getCounter(){
        int index = 0;
        for (int slot : nodeCounter) {
            if (slot==0)index++;
            else return index;
        }
        return index;
    }
}