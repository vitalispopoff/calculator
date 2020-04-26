package input;

import calculation.*;

class NodeQueue extends Queueability implements Queuing {

    int[] nodeCounter = new int[NodeType.values().length];
//    int queuerCounter = 0;

    NodeQueue() {
        super();
    }

    public void convertToLocalTree(){

        /* 1.1 :    extract queue.head from queue */      // * queue.head == opLeft now
        /* 1.2 :    analyze opLeft  */
        /* 1.3 :    is opLeft a value ? */
        /* 2.1 :    extract queue.head from queue */      // * queue.head == opRoot now
        /* 2.2 :    analyze opRoot */
        /* 2.3 :    is opRoot a prioritized operation ? */
        /* 3.1 :    extract queue head from queue */      // * queue.head == opRite now
        /* 3.2 :    analyze opRite */
        /* 3.3 :    is oprite a value ? */

        Enqueued opLeft = updateQueue();
        Enqueued opRoot = updateQueue();
        Enqueued opRite = updateQueue();

        Nodeable opLeftNode = opLeft.getNode();
        Nodeable opRootNode = opRoot.getNode();
        Nodeable opRiteNode = opRite.getNode();

        Typical opLeftNodeType = opLeftNode.getType();
        Typical opRootNodeType = opRootNode.getType();
        Typical opRiteNodeType = opRiteNode.getType();

        boolean isLeftNodeValue = opLeftNodeType == NodeType.VALUE;
        boolean isOpRootProper = isQueueNodePrioritized(opRootNodeType);
        boolean isRiteNodeValue = opRiteNodeType == NodeType.VALUE;

        /* 4. :    if 1.3 , 2.3, 3.3 are true then make them a local tree*/

        if (isLeftNodeValue && isOpRootProper && isRiteNodeValue){

            /* 4.1  overwrite opRoot localLeft with opLeftNode */

            opRootNode.setLocalLeft(opLeftNode);

            /* 4.2  overwite opRoot localRite with opRiteNode */

            opRootNode.setLocalRite(opRiteNode);

            /* 4.3  calculate opRoot */

            opRootNode.setValue();

            /* 4.4  delete opLeft */

            opLeft.setType(null);
            opLeft.setNode(null);

            /* 4.5  delete opRite */

            opRite.setType(null);
            opRite.setNode(null);

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


    Enqueued updateQueue(){
        Enqueued cache = (Enqueued)getHead();
        cache.getTail().setHead(null);
        setHead(null);
        updateCounter();
        return cache;
    }

    void updateQueue(Queueable queuer){

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