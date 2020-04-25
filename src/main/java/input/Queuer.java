package input;

import calculation.*;

public class Queuer extends QueueCore implements Enqueued {

    Typical type = null;
    Nodeable node = null;
    int typeOrdinal = -1;

    @Override
    public void setNode(Nodeable node) {
        this.node = node;
        setType(node);
    }

    int getTypeOrdinal() {
        return typeOrdinal;
    }

    void setTypeOrdinal() {
        Typical cache = getType();
        this.typeOrdinal = cache == null ? -1 : cache.ordinal();
    }

    void setType(Nodeable node) {
        this.type = node.getType();
        setTypeOrdinal();
    }

    //    @formatter:off
    @Override public Typical getType() { return type; }
    @Override public Nodeable getNode() {
        return node;
    }
    //  @formatter:on
}