package input;

import calculation.Nodeable;

public class Queuer implements Queueable {

    Queueable
            ahead = null,
            behind = null;
    Nodeable node = null;

    //    @formatter:off
    void setAhead(Queueable queuer){this.ahead = queuer;}
    void setBehind(Queueable queuer){this.behind = queuer;}
    void setNode(Nodeable node){this.node = node;}
    Queueable getAhead(){return ahead;}
    Queueable getBehind(){return behind;}
    Nodeable getNode(){return node;}
    //    @formatter:on

    @Override
    public void addToQueue(Queueable queuer) {

    }

    @Override
    public Queueable takeFromQueue() {
        return null;
    }

    @Override
    public Queueable leaveQueue() {
        return null;
    }

    @Override
    public int getNodeTypeOrdinal() {
        return 0;
    }
}