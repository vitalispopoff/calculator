package input;

import calculation.Nodeable;

/**
 * :
 * Enables sorting single expressions
 * and delivering them to further processing:
 * filtering (TODO - filtering by operation priority)
 */
public interface Queueable {


    /**
     * :
     * Enables queuer joining the queue
     * the method solves queuers responsibility
     * to remember his ahead and behind
     * queuer fellows
     */
    void joinQueue(Queueable calculationQueue);

    /**
     * :
     * Signs off the queuer while returning its successor
     * (queuer pov)
     * ! takes no responsibility in breaking the queue
     */
    Queueable leaveQueue();

    /**
     * :
     * After extracting node unlinkks the object
     * from the context for the garbage collector,
     * eventually returns the unwrapped node object.
     */
    Nodeable deQueuer();

    /**
     * :
     * Returns the nodeType currently binding the default object
     */
    int getNodeTypeOrdinal();

    /*
     * :
     * Returns a number representing a priority of a node
     * */
//    int getTypePriority();

    /**
     * ???
     */
    Nodeable getNode();

    /**
     * :
     * Returns previous queuer in the line
     */
    Queueable getPrevOne();

    void setPostOne(Queueable postOne);

    /**
     * :
     * Returns another queuer in the line
     */
    Queueable getPostOne();

    /**
     * ???
     */
    void setPrevOne(Queueable queuer);

    void setNode(Nodeable node);

    void addToPriorityTypes(Queueable queuer);

    void removeFromPriorityTypes();

    void addToQueue(Queueable que2);

    Queueable removeFromQueue();

    void convertToLocalTree();

}

/*
 *   adding a queuer to the queue
 *
 *   Upon wishing to join the queue, the queuer sends request
 *   and receives an answer with info about current last queuer inline
 *   (CalculationQueue.postOne)
 *   The queuer updates its prevOne.
 *
 *   The queue requests the current last queuer to updated its postOne
 *   and does the same itself.
 * */    //  ?   adding a queuer to the queue
/*
 *   removing a queuer from the queue
 *
 *   upon leaving the queue, the queuer is asked by the queue
 *   and to updated its postOne right after informing
 *   the postOne to do the same with its prevOne:
 *   postOne.setPrevOne(null);
 *   setPostOne(null);
 *
 *   on its side the queue receiving the link to its prevOne postOne
 *   updates own prevOne
 *   setPrevOne(prevOne.getPostOne());
 *
 * */    //  ?   removing a queuer from the queue