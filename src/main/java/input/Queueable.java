package input;

public interface Queueable {

    Queueable getTail();

    Queueable getHead();

    void setTail(Queueable tail);

    void setHead(Queueable head);

    Queueable evoke();

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
}