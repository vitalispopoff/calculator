package input;

import calculation.Node;

public class Queuer implements Queueable{

    Queueable previous = null;
    Node node;

    Queuer(Node node) {
        this.node = node;
    }

    Queuer(Queuer previous, Node node) {
        this(node);
        this.previous = previous;
    }
}

