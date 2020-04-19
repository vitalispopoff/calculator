package calculation;

import static java.lang.Double.NaN;

public abstract class Node implements Nodeable {

    Nodeable
            localLeft = null,
            localRoot = null,
            localRite = null;
    NodeType
            type;
    Double
            value = NaN;

    public Node(NodeType type) {
        setType(type);
    }

    //    @formatter:off
    @Override public NodeType getType(){return type;}
    @Override public Double getValue(){return value;}
    @Override public Nodeable getLocalLeft(){return localLeft;}
    @Override public Nodeable getLocalRoot(){return localRoot;}
    @Override public Nodeable getLocalRite(){return localRite;}
    @Override public void setType(NodeType type){this.type = type;}
    @Override public void setLocalLeft(Nodeable node){this.localLeft = node;}
    @Override public void setLocalRoot(Nodeable node){this.localRoot = node;}
    @Override public void setLocalRite(Nodeable node){this.localRite = node;}
    //    @formatter:on

    protected abstract Double calculate(Nodeable left, Nodeable rite);
}