package input;

public interface Queuing extends Queueable {

    default Queueable updateQueue() {
        if (getHead() == getTail()) setTail(null);          //Test : updateQueue_sub01
        updateCounter();

        Enqueued cache = (Enqueued) getHead();
        setHead(getHead().getTail());                       //Test : updateQueue_sub02
        cache.setTail(null);                                //Test : updateQueue_sub03
        return cache;                                       //Test : updateQueue_sub00

    }

    default void updateQueue(Queueable queuer) {
        getTail().setTail(queuer);
        queuer.setHead(getTail());
        setTail(queuer);
//        updateCounter(queuer);
    }

    /**
     * :
     * Updates the counters for the queue:
     * adds a new queuer to the counters
     */
    void updateCounter(Queueable queuer);

    /**
     * :
     * Updated the counters for the queue:
     * removes the head queuer from the counters
     */
    void updateCounter();

    void convertToLocalTree();
}