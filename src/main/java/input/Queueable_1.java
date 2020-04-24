package input;

public interface Queueable_1 {

    //  *   ADDING QUEUER / JOINING QUEUE

    /**
     *  1. Queueable queuer requests joining the queue
     */
    public default Queueable addToQueue(Queueable queuer) {
        return this.getTail();
    }

    /**
     *  2. queue returns its tail
     */
    public Queueable getTail();

    /**
     *  3 & 4
     *  3. queue requests the tail to overwrite its tail
     *
     *  4. queue overwrites its tail with the queuer
     * */
    public void setTail(Queueable tail);

    /**
     * 5. queuer overwrites its head
     */
    public void setHead(Queueable head);

    /**
     *  6. queue adds the the priority list
     * */

    /**
     *  7. queue adds to its counter;
     * */


    //  *   REMOVING QUEUER / LEAVING QUEUE

    /**
     *  1. queue request the head its tail
     * */
    public Queueable getHead();

    /**
     *  2 & 3
     *  2. queue requestes head.tail to null its head
     *
     *  3. queue nulls its head
     */
    default public void setHead() {
        setHead(null);
    }

    /**
     *  4. queue removes from its priority list
     * */

    /**
     *  5 queue removes from its counter
     * */

    default Queueable removeFromQueue(){
        Queueable
                leaver = getHead(),
                newHead = leaver.getTail();
        setHead();



        return leaver;
    }

    //  * UNWRAP / DEQUEUER
}
