package input;

public interface Queueable {

    /**
     * :
     * creates an object and adds it to a queue
     * */
    abstract Queueable summon();

    /**
     * :
     * disconnects the queueable object
     * preparing it for interception by the garbage collector
     *
     * */
    default void revoke() {
        Queueable
                head = getHead(),
                tail = getTail();
        if (head != null) {
            head.setTail(null);
            setHead(null);
        }
        if (tail != null) {
            tail.setHead(null);
            setTail(null);
        }
    }

    //    @formatter:off

    Queueable getTail();
    Queueable getHead();
    void setTail(Queueable tail);
    void setHead(Queueable head);

    //    @formatter:on
}