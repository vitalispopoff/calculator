package input;

import calculation.Node;

public class Queuer implements Queueable {

    Queuer
            prev = null,
            next = null;
    Node node = null;

    Queuer() {
    }

    Queuer(Node node) {
        setNode(node);
    }

    Queuer(Queuer prev, Node node) {
        this(node);
        setPrev(prev);
        prev.setNext(this);
    }

    void setNode(Node node) {
        this.node = node;
    }

    void setPrev(Queuer prev) {
        this.prev = prev;
        prev.next = this;
    }

    void setNext(Queuer next) {
        this.next = next;
        next.prev = this;
    }
}