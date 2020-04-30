package input;

import calculation.Typical;
import process.Treeable;

public interface Queuing extends Queueable {

/*    default Queueable updateQueue() {
        if (getHead() == getTail()) setTail(null);          //Test : updateQueue_sub01
        updateCounter();

        Enqueued cache = (Enqueued) getHead();
        setHead(getHead().getTail());                       //Test : updateQueue_sub02
        cache.setTail(null);                                //Test : updateQueue_sub03
        return cache;                                       //Test : updateQueue_sub00
    }*/     // ! wrong - disposable

    default Queueable updateQueue() {
        updateCounter();
        if(getHead()==null) return null;
        else {
            Queueable cache = getHead();
            setHead(cache.getTail());
            if (cache.getTail() != null) cache.setTail(null);

            if (getHead() == null) setTail(null);
            else getHead().setHead(null);


            return cache;
        }
    }

    default void updateQueue(Queueable queuer) {
        queuer.setHead(getTail());


        if(getTail()!=null)getTail().setTail(queuer);
        if(getHead()==null) setHead(queuer);
        setTail(queuer);
        updateCounter(queuer);
    }

    /**
     * ...
     * dupa
     * */
    int getCounter(Queueable queuer);

    /**
     * ...
     * <p><a href="https://github.com/vitalispopoff/calculator/issues/11">Issue #11</a> : simplify  counter</p>
     * <p><a href="https://github.com/vitalispopoff/calculator/issues/10">Issue #10 closed</a> : verify testing for the Queuing</p>
     * <p>Updates the counters for the queue:<br>
     * adds a new queuer to the counters</p>
     * <!--
     * !SSUE#11 : simplify counter - move to the NodeType ?
     * -->
     */
    void updateCounter(Queueable queuer);

    /**
     * ...
     * <p><a href="https://github.com/vitalispopoff/calculator/issues/11">Issue #11</a> : simplify  counter</p>
     * <p><a href="https://github.com/vitalispopoff/calculator/issues/10">Issue #10 closed</a> : verify testing for the Queuing</p>
     * <p>Updated the counters for the queue:<br>
     * removes the head queuer from the counters</p>
     * <!--
     * !SSUE#11 : simplify counter - move to the NodeType?
     * -->
     *
     */
    void updateCounter();

    /**
     * ...
     * <!--
     * !SSUE#1 : subtree construction
     * -->
     * <p><a href="https://github.com/vitalispopoff/calculator/issues/1">Issue #1</a> : Subtree construction</p>
     * <!--
     * !SSUE#9 : bracketing
     * -->
     * <p><a href="https://github.com/vitalispopoff/calculator/issues/9">Issue #9</a> : Add bracketing</p>
     */
    /*void convertToLocalTree();*/

    int currentPriorityIndex();
}