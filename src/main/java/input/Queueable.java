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
     * ! takes no responsibility in breaking the queue
     */
    Queueable leaveQueue();

    /**
     * After extracting node unlinkks the object
     * from the context for the garbage collector,
     * eventually returns the unwrapped node object.
     * */
    Nodeable deQueuer();

    /**
     * returns the nodeType currently binding the default object
     */
    int getNodeTypeOrdinal();

    /**
     * Returns a number representing
     * a priority of a node
     * */
    int getTypePriority();

    /**
     * ???
     * */
    Nodeable getNode();

    /**
     * returns previous queuer in the line
     * */
    Queueable getPrevOne();

    void setPostOne(Queueable postOne);

    /**
     * returns another queuer in the line
     * */
    Queueable getPostOne();

    /**
     * ???
     * */
    void setPrevOne(Queueable queuer);
}