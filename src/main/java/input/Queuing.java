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


    /**
     *   TODO #1 :   <a href="https://github.com/vitalispopoff/calculator/issues/1">Subtree construction</a>
     *   TODO #9 :   <a href="https://github.com/vitalispopoff/calculator/issues/9">Add bracketing</a>
     * */
    void convertToLocalTree();
}