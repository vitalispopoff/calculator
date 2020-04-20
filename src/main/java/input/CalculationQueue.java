package input;

import calculation.NodeType;

public class CalculationQueue extends Queuer {

    public int[] queuerNodeTypes;
    int length = 0;

    public CalculationQueue(Queueable queuer) {
        setQueuerNodeTypes();
        prevOne = postOne = queuer;
        length++;
        //        updatePriority(queuer);
//        queuerNodeTypes[queuer.getNode().getPriority()]++;
//                this.queuerNodeTypes = new int[1 + NodeType.values().length /*>> 1*/];
    }

    public void setQueuerNodeTypes() {
        this.queuerNodeTypes = new int[/*(*/NodeType.values().length /*>> 1) + 1*/];
    }

    void updatePriority(Queueable queuer){
        System.out.println(queuer.getNode().getPriority());
//        queuerNodeTypes[queuer.getNode().getPriority()]++;
//        queuer.getNode().getPriority();

    }

    /*    void constructLocalTree() {
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
            for (int i = 0; i < 2; i++)
                this.addToQueue(this.takeFromQueue());
    }*/

    /*    public Queueable takeFromQueue() {
        if (length == 0) return null;
        else {
            Queueable cache = prevOne;
            prevOne = prevOne.leaveQueue();
            queuerNodeTypes[cache.getTypePriority()]--;
            length--;
            return cache;
        }
    }*/

    /*int currentPriority() {
        int i = 0,
                x = 0;
        for (; i < queuerNodeTypes.length - 1 && x == 0; i++)
            x = queuerNodeTypes[i];
        return i-1;
    }*/
}