package input;

import calculation.*;

public class Queuer implements Queueable {

    public Queueable
            head = null,
            tail = null;
    public Nodeable
            node = null;

    public Queuer() {
    }

    public Queuer(Nodeable node) {
        this.node = node;
    }

    @Override
    public Nodeable deQueuer() {
        Nodeable cache = node;
        setTail(null);
        setNode(null);
        return cache;
    }

    @Override
    public int getNodeTypeOrdinal() {
        try {
            return node.getType().ordinal();
        } catch (NullPointerException ignored) {
            return -1;
        }
    }

    @Override
    public void joinQueue(Queueable calculationQueue) {
        setHead(calculationQueue.getTail());                   //  * connects the node with a queue - node side
        if (head != null) getHead().setTail(this);        //  * connects the queue with the node - queue side
//        if (tail != null) getTail().setHead(this);

/*        if (calculationQueue.getPostOne() == calculationQueue.getPrevOne())
            calculationQueue.setPostOne(this);
        else calculationQueue.getPostOne().setPostOne(this);*/
        }

    public void joinQueue(){}






    @Override
    public Queueable leaveQueue() {
        Queueable result = tail;
        setTail(null);

        return result;
    }

    //    @formatter:off

    @Override public Nodeable getNode() {return node;}
    @Override public Queueable getHead() {
        return head;
    }
    @Override public Queueable getTail() {
        return tail;
    }
    @Override public void setNode(Nodeable node) { this.node = node; }

    @Override public void setHead(Queueable queuer) {
        this.head = queuer;
    }
    @Override public void setTail(Queueable tail) {
        this.tail = tail;
    }

    @Override public void addToPriorityTypes(Queueable queuer) { }
    @Override public void removeFromPriorityTypes() { }
    @Override public void addToQueue(Queueable que2) { }
    @Override public Queueable removeFromQueue() { return null; }
    @Override public void convertToLocalTree() { }
    @Override public boolean isPrevOneValue() {return false;}

    //    @formatter:on

    /*public static void main(String[] args) {

        Typical t = NodeType.VALUE;
        System.out.println(Typical.getTypicalPriority(t));

    }*/ // * psvm
}