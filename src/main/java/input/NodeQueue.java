package input;

import calculation.*;

class NodeQueue extends Queueability implements Queuing {

    int[] nodeCounter = new int[NodeType.values().length];

    NodeQueue(Queueable queueable) {
//        super();
        head = tail = queueable;
        try {
            updateCounter(queueable);
        } catch (Exception e) {
        }
    }

    public void convertToLocalTree() {

        Enqueued
                opLeft = (Enqueued) updateQueue(),
                opRoot = (Enqueued) updateQueue(),
                opRite = (Enqueued) updateQueue();
        Nodeable
                opLeftNode = opLeft.getNode(),
                opRootNode = opRoot.getNode(),
                opRiteNode = opRite.getNode();
        Typical
                opLeftNodeType = opLeftNode.getType(),
                opRootNodeType = opRootNode.getType(),
                opRiteNodeType = opRiteNode.getType();
        boolean
                isOpLeftAVal = opLeftNodeType == NodeType.VALUE,
                isOpRootAPas = isQueueNodePrioritized(opRootNodeType),
                isOpRiteAVal = opRiteNodeType == NodeType.VALUE;

//        if (isOpLeftAVal && isOpRootAPas && isOpRiteAVal) {

        opRootNode.setLocalLeft(opLeftNode);
        opRootNode.setLocalRite(opRiteNode);
        opRootNode.setValue();
        opRiteNodeType = NodeType.VALUE;

        opLeft.setType(null);
        opRite.setType(null);
        opLeft.setNode(null);
        opRite.setNode(null);

        updateQueue(opRoot);

/*        } else {

            updateQueue(opLeft);
            updateQueue(opRoot);
        }*/
    }

    private boolean isQueueNodePrioritized(Typical rootNodeType) {
        return true;
    }

    @Override
    public int getCounter(Queueable queuer) {
        if (queuer == null) return 0;
        else {
            int index = ((Enqueued) queuer).getPriority();
            return nodeCounter[index];
        }
    }

    @Override
    public void updateCounter(Queueable queuer) {
        int index = ((Enqueued) queuer).getPriority();
        nodeCounter[index]++;
    }

    @Override
    public void updateCounter() {
        if (head != null) {
            int index = ((Enqueued) head).getPriority();
            if (nodeCounter[index] > 0) nodeCounter[index]--;
        }
    }

}