package input;

public interface Queuing {

    /**
     * :
     * Adds an entity to the queue
     */
    void addToQueue(Queueable queuer);

    /**
     * :
     * Returns an entity removed the queue
     * (queue pov)
     */
    Queueable takeFromQueue();
}
