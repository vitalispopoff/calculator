package input;

public interface Queueable {

    default void dismiss() {
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