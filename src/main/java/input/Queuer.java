package input;

import calculation.*;

public class Queuer extends Queueability implements Enqueued {

    int
            priorityIndex = -1;
    Typical
            type = null;
    Nodeable
            node = null;

    public Queuer(Nodeable node) {
        setNode(node);
        setType(node.getType());
        setPriorityIndex();
    }

    @Override
    public int getPriorityIndex() {
        return priorityIndex;
    }

    @Override
    public void setPriorityIndex(Typical type) {
        this.priorityIndex = type.getTypePriority();
    }

    @Override
    public void setPriorityIndex() {
        Typical cache = getType();
        this.priorityIndex = cache == null ? -1 : cache.getTypePriority();
    }

    @Override
    public void setNode(Nodeable node) {
        this.node = node;
//        setType(node.getType());
    }

    @Override
    public void setNode() {
        this.node = null;
        this.type = null;
    }

    //    @formatter:off

    @Override public Typical getType() { return type; }
    @Override public Nodeable getNode() { return node; }
    @Override public void setType(Typical type) { this.type = type; }

    //    @formatter:on
}