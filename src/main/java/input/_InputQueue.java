package input;

public class _InputQueue extends Queuer{

    int length = 0;

    _InputQueue(Queuer queuer) {
        prev = next = queuer;
        length++;
    }

    public void setPrev(Queuer node) {
        this.prev = node;
    }

    @Override
    public void addToQueue(Queuer queuer) {
        queuer.setPrev(next);
        next = queuer;
        length++;
    }                                   // ? TODO "joinQueue" ?

    @Override
    public Queueable takeFromQueue() {
        Queuer cache = prev;
        prev = cache.next;
        prev.prev = cache.next = null;
        return cache;
    }                                   // ? TODO leaveQueue ?
}