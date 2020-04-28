package input;

import calculation.*;

class NodeQueue extends Queueability implements Queuing {

    int[] nodeCounter = new int[NodeType.values().length];

    NodeQueue(Queueable queueable) {
        super();
        head = tail = queueable;
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
    public void updateCounter(Queueable queuer) {
        nodeCounter[((Queuer) queuer).getTypeOrdinal()]++;
    }

    @Override
    public void updateCounter() {
        nodeCounter[((Queuer) head).getTypeOrdinal()]--;
    }
}