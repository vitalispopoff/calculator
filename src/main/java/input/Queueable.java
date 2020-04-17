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
    void addToQueue(Queueable queuer);

    /**
     * presents an entity leaving the queue
     */
    Queueable takeFromQueue();

    /**
     * signs off the queuer while returning its successor
     */
    Queueable leaveQueue();

    /**
     * returns the nodeType currently binding the default object
     */
    int getNodeTypeOrdinal();
}