package input;

abstract class Queueability {

    Queueable
            head = null,
            tail = null;

    //  @formatter:off

    Queueability() { }
    Queueability(Queueable queueable) { if (head == null) head = tail = queueable; }

    public Queueable summon() { return null; }
    public Queueable getTail() { return tail; }
    public Queueable getHead() { return head; }
    public void revoke() { }
    public void setTail(Queueable tail) { this.tail = tail; }
    public void setHead(Queueable head) { this.head = head; }

    //    @formatter:on
}