package input;

import calculation.*;

public class Queuer extends Queueability implements Enqueued {

    Typical type = null;
    Nodeable node = null;
    int priorityIndex = -1;

    Queuer(Nodeable node) {
//        super(null);
        setNode(node);
        setType(node.getType());
        setPriority();
    }

    @Override
    public int getPriorityIndex() { return priorityIndex; }

    void setPriority() {
        Typical cache = getType();
        this.priorityIndex = cache == null ? -1 : cache.ordinal();
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