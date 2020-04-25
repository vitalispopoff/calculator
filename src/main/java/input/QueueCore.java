package input;

public abstract class QueueCore implements Queueable {

    Queueable
            head = null,
            tail = null;

    //  @formatter:off

    QueueCore() { }

    @Override public Queueable getTail() { return tail; }
    @Override public Queueable getHead() { return head; }
    @Override public void setTail(Queueable tail) { this.head = tail; }
    @Override public void setHead(Queueable head) { this.tail = head; }

    //    @formatter:on

    /*    @Override
    abstract public Queueable evoke();*/    // ? evoke
}