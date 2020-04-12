package input;

/**
 * interface enables sorting single expressions
 * and delivering them to further processing:
 * filtering (TODO - filtering by operation priority)
 */
public interface Queueable {

    /**
     * adds an entity to the queue
     */
    void addToQueue(Queuer queuer);

    /**
     * presents an entity leaving the queue
     */
    Queueable takeFromQueue();

    /**
     * returns the nodeType currently binding the default object
     */
    int getNodesType();

    /**
     * signs off the queuer while returning its successor
     * */
    Queuer leaveQueue();
}