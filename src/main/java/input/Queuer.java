package input;

import calculation.Node;
import calculation.NodeType;
import calculation.Value;
import calculation.calculations.Calculation_Addition;

public class Queuer implements Queueable {

    Queuer
            prev = null,
            next = null;
    Node node = null;

    Queuer() {
    }

    public Queuer(Node node) {
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

    public void setPrev(Queuer prev) {
        this.prev = prev;
        prev.next = this;
    }

    public void setNext(Queuer next) {
        this.next = next;
        next.prev = this;
    }

    int getNodesType() {
        Node cacheNode = node;
        NodeType cacheType = cacheNode.getType();
        return cacheType.ordinal();
    }

    //    @Formatter:off
    @Override public void addToQueue(Queuer queuer) {}
    @Override public Queueable takeFromQueue() {return null;}
    //    @Formetter:on
}