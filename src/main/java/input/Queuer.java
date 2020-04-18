package input;

import calculation.Nodeable;

public class Queuer implements Queueable {

    Queueable
            prevOne = null,
            nextOne = null;
    Nodeable
            node = null;

    @Override
    public void joinQueue(Queueable calculationQueue) {
        prevOne = calculationQueue.getNextOne();
    }

    @Override
    public Queueable leaveQueue() {
        Queueable result = nextOne;
        nextOne = null;
        return result;
    }

    //    @formatter:off
    @Override public void addToQueue(Queueable queuer) { }
    @Override public Queueable takeFromQueue() {return null;}
    @Override public int getNodeTypeOrdinal() {return 0;}

    void setPrevOne(Queueable queuer){this.prevOne = queuer;}
    void setNextOne(Queueable queuer){this.nextOne = queuer;}
    void setNode(Nodeable node){this.node = node;}

    public Queueable getPrevOne(){return prevOne;}
    public Queueable getNextOne(){return nextOne;}
    public Nodeable getNode(){return node;}
    public int getTypePriority(){return getNode().getTypePriority();}
    //    @formatter:on
}