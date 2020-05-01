package input;

import calculation.*;

public interface Enqueued extends Queueable {

    /**
     * <!---->
     * <p>Unwrap node</p>
     *<ol>
     *  <li>node is the result</li>
     *  <li>node is deleted</li>
     *  <li>result is returned</li>
     *  </ol>
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
     * <!---->
     *     <p>Returns priority index of the queuer rather than its carried nodeable.</p>
     * */
    int getPriorityIndex();

    /**
     * <!---->
     *     <p>Sets the priority of the queuer.</p>
     * */
    void setPriorityIndex();

    /**
     * <!---->
     *     <p>Sets the priority index of the queuer base on the provided type</p>
     * */
    void setPriorityIndex(Typical type);

    Typical getType();

    void setType(Typical type);

    Nodeable getNode();

    void setNode(Nodeable node);

    void setNode();
}