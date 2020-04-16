package _temp.input;

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
     * signs off the queuer while returning its successor
     */
    Queuer leaveQueue();

    /**
     * returns the nodeType currently binding the default object
     */
    int getNodeTypeOrdinal();
}