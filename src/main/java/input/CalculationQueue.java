package input;

import calculation.Node;
import calculation.NodeType;
import calculation.Nodeable;
import calculation.Value;

public class CalculationQueue extends Queuer {

    int[] queuerNodeTypes;
    int length = 0;

    CalculationQueue(Queueable queuer) {
        this.queuerNodeTypes = new int[1 + NodeType.values().length >> 1];
        prevOne = nextOne = queuer;
        queuerNodeTypes[queuer.getNode().getTypePriority()]++;
        length++;
    }

    void constructLocalTree() {
        Queueable
                cache = prevOne;
        int
                currentFrontQueuerType = cache.getTypePriority(),
                nextFrontQueuerType = cache.getNextOne().getTypePriority();
        boolean
                currentFrontIsValue = nextFrontQueuerType == NodeType.VALUE.ordinal() >> 1;

        Nodeable
                cacheNodeRoot = cache.getNode(),
                cacheNodeLeft = cacheNodeRoot.getLocalLeft(),
                cacheNodeRite = cacheNodeRoot.getLocalRite();
    }


    //    @formatter:off
    int getLength(){return length;}
    //  @formatter:on
}