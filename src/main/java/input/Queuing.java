package input;

public interface Queuing extends Queueable{

    /**
     * :
     * Adding queuer / joining queue
     * <p>
     * 1. the queue returns its tail
     * 2. the queuer overwrites its head as the queue tail
     * 3. the queue tail overwrites its own tail as the queuer
     * 4. the queue overwrites its tail as the queuer
     * 5. the queue counters are decreased
     */
    static void extendQueue(Queueable nodeQueue, Queueable queuer) {
        queuer.setHead(nodeQueue.getTail());
        nodeQueue.getTail().setTail(queuer);
        nodeQueue.setTail(queuer);
//        ((Queuing) nodeQueue).increaseQueueCounter();
    }

    /**
     * :
     * Removing queuer / leaving queue
     * <p>
     * 0. queue head is the queuer.
     * 1. queuer tail is set as the queue head
     * 2. the queue head nulls its head
     * 3. the queuer nulls its tail
     * 4. the queue counters are decreased
     * 5. the queue returns the queuer
     */
    static Queueable reduceQueue(Queueable nodeQueue) {
        Queueable queuer = nodeQueue.getHead();
        nodeQueue.setHead(queuer.getTail());
        nodeQueue.getHead().setHead(null);
        queuer.setTail(null);
//        ((Queuing) nodeQueue).updateCounters();
        return queuer;
    }

    /**
     * :
     * Updates the counters for the queue:
     * adds a new queuer to the counters
     * */
    void updateCounter(Queueable queuer);

    /**
     * :
     * Updated the counters for the queue:
     * removes the head queuer from the counters
     * */
    void updateCounter();



    void convertToLocalTree();
}