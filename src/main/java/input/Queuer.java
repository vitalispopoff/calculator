package input;

import calculation.*;

public class Queuer extends QueueCore implements Enqueued {

    Typical type = null;
    Nodeable node = null;
    int typeOrdinal = -1;

    Queuer(Nodeable node) {
        super(null);
        setNode(node);
        setType(node.getType());
        setTypeOrdinal();
    }

    void setTypeOrdinal() {
        Typical cache = getType();
        this.typeOrdinal = cache == null ? -1 : cache.ordinal();
    }

    int getTypeOrdinal() { return typeOrdinal; }

    @Override
    public void setNode(Nodeable node) {
        this.node = node;
        setType(node.getType());
    }

    //    @formatter:off

    @Override public Typical getType() { return type; }
    @Override public Nodeable getNode() { return node; }
    @Override public void setType(Typical type) { this.type = type; }

    //    @formatter:on
}