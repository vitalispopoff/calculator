package input;

import calculation.*;

public interface Enqueued {

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
        Nodeable result = getNode();
        setNode(null);
        return result;
    }

    Typical getType();
    Nodeable getNode();
    void setNode(Nodeable node);
//    void setType(Typical type);
}