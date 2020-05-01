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

    @Override
    public void setValue() {
        if (value.isNaN()) {
            value = calculate(localLeft, localRite);
//            if (type != NodeType.VALUE) type = NodeType.VALUE;
        }
    }

    @Override
    public Double getValue() {
        if (value.isNaN()) setValue();
        return value;
    }

    //    @formatter:off

    @Override public Typical getType(){return type;}
    @Override public Nodeable getLocalLeft(){return localLeft;}
    @Override public Nodeable getLocalRoot(){return localRoot;}
    @Override public Nodeable getLocalRite(){return localRite;}

    @Override public void setType(Typical type){this.type = type;}
    @Override public void setValue(Double value){ this.value = value; }
    @Override public void setLocalLeft(Nodeable node){this.localLeft = node;}
    @Override public void setLocalRoot(Nodeable node){this.localRoot = node;}
    @Override public void setLocalRite(Nodeable node){this.localRite = node;}

    protected Double calculate(Nodeable localLeft, Nodeable localRite) {
        return NaN;
    }

    //    @formatter:on
}