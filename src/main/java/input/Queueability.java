package input;

abstract class Queueability {

    Queueable
            head = null,
            tail = null;

    //  @formatter:off

    Queueability() { }

    public Queueable getTail() { return tail; }
    public Queueable getHead() { return head; }
    public void setTail(Queueable tail) { this.tail = tail; }
    public void setHead(Queueable head) { this.head = head; }

    //    @formatter:on
}