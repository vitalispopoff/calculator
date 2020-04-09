package input;

public class _InputQueue extends Queuer {

    int length = 0;
    Queuer
            head = null,
            tail = null;

    _InputQueue(Queuer queuer) {
        head = tail = queuer;
        length++;
    }

    void setHead(Queuer node) {
        this.head = node;
    }

    void addToQueue(Queuer queuer) {
        queuer.setPrev(tail);
        tail = queuer;
        length++;
    }                                   // ? TODO "joinQueue" ?

    Queueable takeFromQueue() {
        Queuer cache = head;
        head = cache.next;
        head.prev = cache.next = null;
        return cache;
    }                                   // ? TODO leaveQueue ?
}