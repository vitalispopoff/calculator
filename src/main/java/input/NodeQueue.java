package input;

import calculation.*;

class NodeQueue extends Queueability implements Queuing {

    int[] nodeCounter = new int[NodeType.values().length];
//    int queuerCounter = 0;

    NodeQueue() {
        super();
    }

    public void convertToLocalTree() {

        /* 1.1 :    extract queue.head from queue */      // * queue.head == opLeft now
        /* 2.1 :    extract queue.head from queue */      // * queue.head == opRoot now
        /* 3.1 :    extract queue head from queue */      // * queue.head == opRite now
        /* 1.2 :    analyze opLeft  */
        /* 2.2 :    analyze opRoot */
        /* 3.2 :    analyze opRite */
        /* 1.3 :    is opLeft a value ? */
        /* 2.3 :    is opRoot a prioritized operation ? */
        /* 3.3 :    is oprite a value ? */

        Enqueued
                opLeft = updateQueue(),
                opRoot = updateQueue(),
                opRite = updateQueue();
        Nodeable
                opLeftNode = opLeft.getNode(),
                opRootNode = opRoot.getNode(),
                opRiteNode = opRite.getNode();
        Typical
                opLeftNodeType = opLeftNode.getType(),
                opRootNodeType = opRootNode.getType(),
                opRiteNodeType = opRiteNode.getType();
        boolean
                isLeftNodeValue = opLeftNodeType == NodeType.VALUE,
                isOpRootProper = isQueueNodePrioritized(opRootNodeType),
                isRiteNodeValue = opRiteNodeType == NodeType.VALUE;

        /* 4. :    if 1.3 , 2.3, 3.3 are true then make them a local tree*/

        if (isLeftNodeValue && isOpRootProper && isRiteNodeValue) {

            /* 4.1  overwrite opRoot localLeft with opLeftNode */
            /* 4.4  delete opLeft */

            opRootNode.setLocalLeft(opLeftNode);
            opLeft.setType(null);
            opLeft.setNode(null);

            /* 4.2  overwite opRoot localRite with opRiteNode */
            /* 4.5  delete opRite */

            opRootNode.setLocalRite(opRiteNode);
            opRite.setType(null);
            opRite.setNode(null);

            /* 4.3  calculate opRoot */

            opRootNode.setValue();

            /* 4.6  update opRoot type */

            opRiteNodeType = NodeType.VALUE;

            /* 4.7  add opRoot to the queue*/

            updateQueue(opRoot);
        } else {

            /* 5.1  add opLeft back to the queue */

            updateQueue(opLeft);

            /*5.2   add opRoot back to the queue */

            updateQueue(opRoot);
        }
    }

    private boolean isQueueNodePrioritized(Typical rootNodeType) {
        return false;
    }


    Enqueued updateQueue() {
        Enqueued cache = (Enqueued) getHead();
        cache.getTail().setHead(null);
        setHead(null);
        updateCounter();
        return cache;
    }

    void updateQueue(Queueable queuer) {

        getTail().setTail(queuer);
        queuer.setHead(getTail());
        setTail(queuer);
        updateCounter(queuer);
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