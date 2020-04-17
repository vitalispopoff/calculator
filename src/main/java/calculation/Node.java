package calculation;

public abstract class Node implements Nodeable {

    static Nodeable globalRoot;
    Nodeable
            localLeft = null,
            localRoot = null,
            localRite = null;

    //    @formatter:off
    void setGlobalRoot(Nodeable node){globalRoot = node;}
    void setLocalLeft(Nodeable node){this.localLeft = node;}
    void setLocalRoot(Nodeable node){this.localRoot = node;}
    void setLocalRite(Nodeable node){this.localRite = node;}
    Nodeable getGlobalRoot(){return globalRoot;}
    Nodeable getLocalLeft(){return localLeft;}
    Nodeable getLocalRoot(){return localRoot;}
    Nodeable getLocalRite(){return localRite;}
    //    @formatter:on
}