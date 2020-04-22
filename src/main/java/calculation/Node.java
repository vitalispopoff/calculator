package calculation;

import static java.lang.Double.NaN;

public abstract class Node implements Nodeable {

    Nodeable
            localLeft = null,
            localRoot = null,
            localRite = null;
    Typical
            type;
    Double
            value = NaN;

    public Node(Typical type) {
        setType(type);
    }

    //    @formatter:off
    @Override public Typical getType(){return type;}
    @Override public Double getValue(){return value;}
    @Override public Nodeable getLocalLeft(){return localLeft;}
    @Override public Nodeable getLocalRoot(){return localRoot;}
    @Override public Nodeable getLocalRite(){return localRite;}
    @Override public void setType(Typical type){this.type = type;}
    @Override public void setLocalLeft(Nodeable node){this.localLeft = node;}
    @Override public void setLocalRoot(Nodeable node){this.localRoot = node;}
    @Override public void setLocalRite(Nodeable node){this.localRite = node;}
    //    @formatter:on

    protected abstract Double calculate(Nodeable localLeft, Nodeable localRite);
}