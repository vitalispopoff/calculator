package input;

import calculation.NodeType;

public class _InputQueue extends Queuer {

    int length = 0;                                                                                                     // TODO may be disposable ?
    int[] nodePriorities;

    _InputQueue(Queuer queuer) {
        this.nodePriorities = new int[NodeType.values().length];
        nodePriorities[queuer.getNodesType()]++;
        prev = next = queuer;
        length++;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void addToQueue(Queuer queuer) {
        nodePriorities[queuer.getNodesType()]++;
        queuer.setPrev(next);
        next = queuer;
        length++;
    }

    @Override
    public Queueable takeFromQueue() {

        if (length > 1) {
            Queuer cache = prev;
            prev = cache.next;
            prev.prev = cache.next = null;
            nodePriorities[cache.getNodesType()]--;
            length--;
            return cache;
        } else if (length == 1) {
            Queuer cache = prev;
            prev = next = null;
            nodePriorities[cache.getNodesType()]--;
            length--;
            return cache;
        } else return null;
    }
}