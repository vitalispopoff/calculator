package input;

import calculation.NodeType;
import calculation.Value;
import calculation.calculations.Calculation_Exponentiation;
import org.junit.Assert;

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
        if (length == 0) return null;
        else {
            Queuer cache = prev;
            prev = prev.leaveQueue();
            nodePriorities[cache.getNodesType()]--;
            length--;
            return cache;
        }
    }

    @Override
    public int getNodesType() {
        int
                cache = 0,
                i = -1;
        while (cache == 0)
            cache = nodePriorities[++i];
        return i;
    }
}