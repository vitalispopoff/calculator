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
    void setType(NodeType type){this.type = type;}
    void setValue(Double value){this.value = value;}
    void setLocalLeft(Nodeable node){this.localLeft = node;}
    void setLocalRoot(Nodeable node){this.localRoot = node;}
    void setLocalRite(Nodeable node){this.localRite = node;}

    public NodeType getType(){return type;}
    public int getTypePriority(){return type.ordinal()>>1;}

    @Override public Double getValue(){return value;}
    @Override public Nodeable getLocalLeft(){return localLeft;}
    @Override public Nodeable getLocalRoot(){return localRoot;}
    @Override public Nodeable getLocalRite(){return localRite;}
    //    @formatter:on

    protected abstract Double calculate(Nodeable left, Nodeable rite);
}