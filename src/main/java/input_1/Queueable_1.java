package input_1;

public interface Queueable_1 {

    /**
     * Adding queuer / joining queue
     *
     * 1. the queue returns its tail
     * 2. the queuer overwrites its head as the queue tail
     * 3. the queue tail overwrites its own tail as the queuer
     * 4. the queue overwrites its tail as the queuer
     * 5. the queue counters are decreased
     * */
    default void addToQueue(Queueable_1 queuer){
        queuer.setHead(getTail());
        getTail().setTail(queuer);
        setTail(queuer);
        increaseQueueCounter();
    }

    /**
     * Removing queuer / leaving queue
     *
     * 0. queue head is the queuer.
     * 1. queuer tail is set as the queue head
     * 2. the queue head nulls its head
     * 3. the queuer nulls its tail
     * 4. the queue counters are decreased
     * 5. the queue returns the queuer
     * */
    default Queueable_1 removeFromQueue(){
        Queueable_1 queuer = getHead();
        setHead(queuer.getTail());
        getHead().setHead(null);
        queuer.setTail(null);
        decreaseQueueCounter();
        return queuer;
    }

     Queueable_1 getTail();
     Queueable_1 getHead();
     void setTail(Queueable_1 tail);
     void setHead(Queueable_1 head);
     void increaseQueueCounter();
     void decreaseQueueCounter();

    //  * deQueuer / unwrap
}
