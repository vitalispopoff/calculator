package input;

import calculation.*;

public interface Enqueued extends Queueable {

    /**
     * :
     * Wrap node
     *
     *  1.  node is written to the queuer
     *  2   queuer is returned as Queueable
     * */
    default Queueable wrap(Nodeable node){
        setNode(node);
        return (Queueable) this;
    }

    /**
     * :
     * Unwrap node
     *
     *  1.  node is the result
     *  2.  node is deleted
     *  3.  result is returned
     * */
    default Nodeable unwrap(){
        Nodeable node = getNode();
        setType(null);
//        setNode(null);
        setHead(null);
        setTail(null);
        return node;
    }



    /**
     * :
     * Returns type of wrapped Node
     * */
    Typical getType();

    int getPriorityIndex();

    void setPriorityIndex();

    void setPriorityIndex(Typical type);

    /**
     * :
     * Returns the wrapped node
     * */
    Nodeable getNode();

    /**
     * :
     * wraps node
     * */
    void setNode(Nodeable node);

    void setNode();

    /**
     * :
     * sets
     * */
    void setType(Typical type);
}