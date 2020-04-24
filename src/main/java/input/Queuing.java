package input;

public interface Queuing {

    /**
     * :
     * Adds an entity to the queue
     * Upon wishing to join the queue, the queuer sends request
     * and receives an answer with info about current last queuer inline
     * (CalculationQueue.postOne). The queuer updates its prevOne.
     * The queue requests the current last queuer to updated its postOne
     * and does the same itself.
     */
    void addToQueue(Queueable queuer);

    /**
     * :
     * Returns an entity removed the queue
     * (queue pov)
     */
    Queueable removeFromQueue();
}


