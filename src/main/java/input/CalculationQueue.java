package input;

import calculation.NodeType;
import calculation.Nodeable;

public class CalculationQueue extends Queuer {

    int[] queuerNodeTypes;
    int length = 0;

    CalculationQueue(Queueable queuer) {
        this.queuerNodeTypes = new int[1 + NodeType.values().length >> 1];
        prevOne = posttOne = queuer;
        queuerNodeTypes[queuer.getNode().getPriority()]++;
        length++;
    }

    void constructLocalTree() {
        Queueable
                cache = prevOne;
        int
                currentFrontQueuerPriority = cache.getTypePriority(),
                nextFrontQueuerPriority = cache.getPosttOne().getTypePriority(),
                valuePriority = NodeType.VALUE.getPriority(),
                bracketPriority = NodeType.BRACKET_OUT.getPriority();
        boolean
                currentFrontIsValue = currentFrontQueuerPriority == valuePriority,
                nextFrontIsValue = nextFrontQueuerPriority == valuePriority,
                nextFrontIsCalculation
                        = nextFrontQueuerPriority > bracketPriority
                        && nextFrontQueuerPriority < valuePriority;

        if (currentFrontQueuerPriority == NodeType.VALUE.getPriority()
                && nextFrontQueuerPriority <= currentPriority()) {

            Queueable
                    cacheRoot = takeFromQueue(),
                    cacheRite;
            Nodeable
                    cacheLeft = takeFromQueue().deQueuer(),
                    cacheRootNode = cacheRoot.getNode();

            cacheRite = nextFrontIsValue ? takeFromQueue() : null;
            cacheRootNode.setLocalLeft(cacheLeft);
            cacheRootNode.setLocalRite(cacheRite.getNode());
            addToQueue(cacheRoot);
        } else
            for (int i = 0; i <2 ; i++)
                this.addToQueue(this.takeFromQueue());
    }

    public Queueable takeFromQueue() {
        if (length == 0) return null;
        else {
            Queueable cache = prevOne;
            prevOne = prevOne.leaveQueue();
            queuerNodeTypes[cache.getTypePriority()]--;
            length--;
            return cache;
        }
    }

    int currentPriority() {
        int
                i = -1,
                x = 0;
        for (; i < queuerNodeTypes.length - 1 && x == 0; )
            x = queuerNodeTypes[++i];
        return i;
    }

    //    @formatter:off
    int getLength(){return length;}
    //  @formatter:on


}
