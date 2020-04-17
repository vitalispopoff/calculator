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
    NodeType getType(){return type;}
    public Double getValue(){return value;}
    Nodeable getLocalLeft(){return localLeft;}
    Nodeable getLocalRoot(){return localRoot;}
    Nodeable getLocalRite(){return localRite;}
    //    @formatter:on

    protected abstract Double calculate(Nodeable left, Nodeable rite);
}