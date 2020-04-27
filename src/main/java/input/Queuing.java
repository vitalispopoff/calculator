package input;

public interface Queuing extends Queueable{

    default Queueable updateQueue() {
        Enqueued cache = (Enqueued) getHead();
        cache.getTail().setHead(null);
        setHead(null);
        updateCounter();
        return cache;
    }

    default void updateQueue(Queueable queuer) {
        getTail().setTail(queuer);
        queuer.setHead(getTail());
        setTail(queuer);
        updateCounter(queuer);
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