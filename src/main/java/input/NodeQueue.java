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

        Enqueued opLeft = updateQueue();

        /* 1.2 :    analyze opLeft  */

        Nodeable opLeftNode = opLeft.getNode();
        Typical opLeftNodeType = opLeftNode.getType();

        /* 1.3 :    is opLeft a value ? */

        boolean isLeftNodeValue = opLeftNodeType == NodeType.VALUE;

        /* 2.1 :    extract queue.head from queue */      // * queue.head == opRoot now

        Enqueued opRoot = updateQueue();

        /* 2.2 :    analyze opRoot */

        Nodeable opRootNode = opRoot.getNode();
        Typical opRootNodeType = opRootNode.getType();

        /* 2.3 :    is opRoot a prioritized operation ? */

        boolean isOpRootProper = isQueueNodePrioritized(opRootNodeType);

        /* 3.1 :    extract queue head from queue */      // * queue.head == opRite now

        Enqueued opRite = updateQueue();

        /* 3.2 :    analyze opRite */

        Nodeable opRiteNode = opRite.getNode();
        Typical opRiteNodeType = opRiteNode.getType();

        /* 3.3 :    is oprite a value ? */

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