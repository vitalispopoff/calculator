package input;

import calculation.*;

public class Queuer extends Queueability implements Enqueued {

    Typical type = null;
    Nodeable node = null;
    int typeOrdinal = -1;

    Queuer(Nodeable node) {
        super(null);
        setNode(node);
        setType(node.getType());
        setTypeOrdinal();
    }

    int getTypeOrdinal() { return typeOrdinal; }

    void setTypeOrdinal() {
        Typical cache = getType();
        this.typeOrdinal = cache == null ? -1 : cache.ordinal();
    }

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