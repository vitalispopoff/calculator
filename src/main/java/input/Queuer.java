package input;

import calculation.Node;

public class Queuer implements Queueable {

    Queuer
            previous = null,
            next = null;
    Node node = null;

    Queuer() {
    }

    Queuer(Node node) {
        this.node = node;
    }

    Queuer(Queuer previous, Node node) {
        this(node);
        setPrevious(previous);
        previous.setNext(this);
    }

    void setPrevious(Queuer previous) {
        this.previous = previous;
        previous.next = this;
    }
    void setNext(Queuer next){
        this.next = next;
        next.previous = this;
    }
}