package input;

import calculation.*;

public class Queuer implements Queueable {

    public Queueable
            prevOne = null,
            postOne = null;
    public Nodeable
            node = null;

    public Queuer() {
    }
    public Queuer(Nodeable node) {
        this.node = node;
    }

    @Override
    public void joinQueue(Queueable calculationQueue) {
        prevOne = calculationQueue.getPostOne();
        if (prevOne != null) prevOne.setPostOne(this);
        if (postOne != null) postOne.setPrevOne(this);

        if (calculationQueue.getPostOne() == calculationQueue.getPrevOne())
            calculationQueue.setPostOne(this);
        else calculationQueue.getPostOne().setPostOne(this);
    }

    @Override
    public Queueable leaveQueue() {
        Queueable result = postOne;
        setPostOne(null);
        return result;
    }

    @Override
    public Nodeable deQueuer() {
        Nodeable cache = node;
        setPostOne(null);
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

//    @formatter:off

    @Override public void addToQueue(Queueable queuer) {
    }
    @Override public Queueable takeFromQueue() {
        return null;
    }
    @Override public void setPostOne(Queueable postOne) {
        this.postOne = postOne;
    }

    public void setPrevOne(Queueable queuer) {
        this.prevOne = queuer;
    }
    void setNode(Nodeable node) {
        this.node = node;
    }
    public Queueable getPrevOne() {
        return prevOne;
    }
    public Queueable getPostOne() {
        return postOne;
    }
    public Nodeable getNode() {
        return node;
    }

//    @formatter:on

    public static void main(String[] args) {

        Typical t = NodeType.VALUE;
        System.out.println(Typical.getTypicalPriority(t));

    }
}