package input;

import calculation.Nodeable;

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
     * presents an entity removed the queue
     * (queue pov)
     */
    Queueable takeFromQueue();

    /**
     * queuer joins the queue
     * the method solves queuers responsibility
     * to remember his ahead and behind
     * queuer fellows
     * */
    void joinQueue(Queueable calculationQueue);

    /**
     * signs off the queuer while returning its successor
     * (queuer pov)
     */
    Queueable leaveQueue();

    /**
     * returns the nodeType currently binding the default object
     */
    int getNodeTypeOrdinal();

    Nodeable getNode();

    /**
     * returns another queuer in the line
     * */
    Queueable getPosttOne();

    /**
     * returns previous queuer in the line
     * */
    Queueable getPrevOne();

    /**
     * Returns a number representing
     * a priority of a node
     * */
    int getTypePriority();

    Nodeable deQueuer();
}