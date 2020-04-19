package input;

import calculation.Nodeable;

public class Queuer implements Queueable {

    Queueable
            prevOne = null,
            postOne = null;
    Nodeable
            node = null;

    @Override
    public void joinQueue(Queueable calculationQueue) {
        prevOne = calculationQueue.getPostOne();
        if (prevOne != null)prevOne.setPostOne(this);
        if (postOne != null)postOne.setPrevOne(this);

        if (calculationQueue.getPostOne() == calculationQueue.getPrevOne())
            calculationQueue.setPostOne(this);
        else calculationQueue.getPostOne().setPostOne(this);
    }

    @Override
    public Queueable leaveQueue() {
        Queueable result = postOne;
        postOne = null;
        return result;
    }

    @Override
    public Nodeable deQueuer() {
        Nodeable cache = node;
//        leaveQueue();
        node = null;
        return cache;
    }

    //    @formatter:off
    @Override public void addToQueue(Queueable queuer) { }
    @Override public Queueable takeFromQueue() {return null;}
    @Override public int getNodeTypeOrdinal() {return 0;}
    @Override public void setPostOne(Queueable postOne) {this.postOne = postOne;}
//    public int getLength() {return length;}

    public void setPrevOne(Queueable queuer){this.prevOne = queuer;}
    void setNode(Nodeable node){this.node = node;}

    public Queueable getPrevOne(){return prevOne;}
    public Queueable getPostOne(){return postOne;}
    public Nodeable getNode(){return node;}
    public int getTypePriority(){return getNode().getPriority();}
    //    @formatter:on
}