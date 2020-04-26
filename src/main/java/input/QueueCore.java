package input;

import calculation.Nodeable;

/*public*/ abstract class QueueCore /*implements Queueable*/ {

    Queueable
            head = null,
            tail = null;

    QueueCore(){ }
    QueueCore(Queueable queueable){
        if (head== null) head = queueable;
    }
    //  @formatter:off


    /*@Override*/ public Queueable summon() { return null; }
    /*@Override*/ public Queueable getTail() { return tail; }
    /*@Override*/ public Queueable getHead() { return head; }
    /*@Override*/ public void revoke() { }
    /*@Override*/ public void setTail(Queueable tail) { this.head = tail; }
    /*@Override*/ public void setHead(Queueable head) { this.tail = head; }

    //    @formatter:on
}