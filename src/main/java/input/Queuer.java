package input;

import calculation.Node;

public class Queuer implements Queueable {

    Queueable
            prev = null,
            next = null;
    Node node = null;

    Queuer() {
    }

    public Queuer(Node node) {
        setNode(node);
    }

    Queuer(/*Queuer*/ Queueable prev, Node node) {
        this(node);
        setPrev(prev);
        prev.setNext(this);
    }

    void setNode(Node node) {
        this.node = node;
    }

    @Override
    public void setPrev(/*Queuer*/ Queueable prev) {
        this.prev = prev;
//        prev.next = this;
        prev.setNext(this);
    }

    @Override
    public void setNext(/*Queuer*/ Queueable next) {
        this.next = next;
//        next.prev = this;
        next.setPrev(this);
    }

    //    @Formatter:off
    @Override public void addToQueue(Queuer queuer) {}
    @Override public Queueable takeFromQueue() {return null;}
    //    @Formetter:on
}