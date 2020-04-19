package input;

import calculation.Nodeable;

public class Queuer implements Queueable {

    Queueable
            prevOne = null,
            posttOne = null;
    Nodeable
            node = null;

    @Override
    public void joinQueue(Queueable calculationQueue) {
        prevOne = calculationQueue.getPosttOne();
    }

    @Override
    public Queueable leaveQueue() {
        Queueable result = posttOne;

        posttOne = null;
        return result;
    }

    @Override
    public Nodeable deQueuer(){
        Nodeable cache = node;
        leaveQueue();
        node = null;
        return cache;
 }

    //    @formatter:off
    @Override public void addToQueue(Queueable queuer) { }
    @Override public Queueable takeFromQueue() {return null;}
    @Override public int getNodeTypeOrdinal() {return 0;}

    public void setPrevOne(Queueable queuer){this.prevOne = queuer;}
    void setPosttOne(Queueable queuer){this.posttOne = queuer;}
    void setNode(Nodeable node){this.node = node;}

    public Queueable getPrevOne(){return prevOne;}
    public Queueable getPosttOne(){return posttOne;}
    public Nodeable getNode(){return node;}
    public int getTypePriority(){return getNode().getTypePriority();}
    //    @formatter:on
}