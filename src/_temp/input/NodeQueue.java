package input;

import calculation.*;

public class NodeQueue extends Queuer implements Queuing {

    int[] priorityTypes;
    int length = 0;

    public NodeQueue(Queueable queuer) {
        setPriorityTypes();
        addToPriorityTypes(queuer);
        head = tail = queuer;
        length++;
    }

    public void setPriorityTypes() {
        this.priorityTypes = new int[NodeType.values().length];
    }

    @Override
    public void addToPriorityTypes(Queueable queuer) {
        int index = queuer.getNodeTypeOrdinal();
        priorityTypes[index]++;
    }

    @Override
    public void removeFromPriorityTypes() {
        int index = head.getNodeTypeOrdinal();
        priorityTypes[index]--;
    }

    @Override
    public void addToQueue(Queueable queuer) {
        tail.setTail(queuer);
        queuer.joinQueue(this);
        setTail(queuer);
        addToPriorityTypes(queuer);
        length++;
    }

    @Override
    public Queueable removeFromQueue() {
        removeFromPriorityTypes();
        length--;
        Queueable
                result = head;                   //  * local reference of the 1st queuer
        head = head.getTail();             //  * sets 2nd as a new 1st
        result.getTail().setHead(null);       //  * resets the the queuer connection new 1st side
        result.setTail(null);                    //  * resets the the queuer connection on old 1st side


        return result;
    }

    @Override
    public void convertToLocalTree() {

        if (isPrevOneValue() && isCurrentLocalTreePrioritized()) {
            Nodeable
                    cacheLeftNode = removeFromQueue().deQueuer(),
                    cacheRootNode;
            Queueable
                    cacheLeft = new NodeQueue(new Queuer(cacheLeftNode)),
                    cacheRoot = removeFromQueue(),
                    cacheRite;
            cacheRootNode = cacheRoot.getNode();
            cacheRite = isPrevOneValue() ? removeFromQueue() : null;

            cacheRoot.setHead(cacheLeft);
            cacheRootNode.setLocalRite(cacheRite.getNode());
            cacheRootNode.setValue();       // TODO reimplement setValue
            addToQueue(cacheRoot);
        } else rebuffLocalTreeNodes();
    }

    public boolean isPrevOneValue() {
        return head.getNodeTypeOrdinal() == NodeType.VALUE.ordinal();
    }

    private boolean isCurrentLocalTreePrioritized() {
        return this.getNodeTypeOrdinal() == head.getTail().getNodeTypeOrdinal();
    }

    private void rebuffLocalTreeNodes() {
        for (int i = 0; i < 2; i++) addToQueue(removeFromQueue());
    }
}


/**
 * :
 * Node Queue - queuer communication.
 * <p>
 * Adding queuer / joining queue.
 * <p>
 * 1) queuer introduces to the queue           nodeQueue: public addToQueue(Queueable queuer)
 * 2) queue returns tail
 * 3) queuer overwrites its head
 * 4) queue sends queuer to queue.tail
 * 5) queue.tail overwrites its tail
 * 6) queue overwrites its tail
 * <p>
 * * * *
 * <p>
 * Removing queuer / quiting queue.
 * (queue returns head)
 * 1) queue request head.tail
 * 3) queue request 'head'.tail to null its head
 * 4) head nulls its tail
 */