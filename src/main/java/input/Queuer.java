package input;

import calculation.Node;
import calculation.NodeType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Queuer implements Queueable/*, ActionListener*/ {

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

    Node getNode() {
        return node;
    }

    public void setPrev(Queuer prev) {
        this.prev = prev;
        if (prev != null) prev.next = this;
    }

    public void setNext(Queuer next) {
        this.next = next;
        if (next != null) next.prev = this;
    }

    Node deQueuer() {
        Node cache = node;
        leaveQueue();
        node = null;
        return cache;
    }

    @Override
    public Queuer leaveQueue() {
        Queuer cache = next;
        if (next != null) next.prev = prev;
        if (prev != null) prev.next = next;
        prev = next = null;
        return cache;
    }

    @Override
    public int getNodeTypeOrdinal() {
        Node cacheNode = node;
        NodeType cacheType = cacheNode.getType();
        return cacheType.ordinal();
    }

/*
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("click");
    }
*/

    //    @Formatter:off
    @Override public void addToQueue(Queuer queuer) {}
    @Override public Queueable takeFromQueue() {return null;}
    //    @Formetter:on
}