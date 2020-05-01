package input;

import calculation.*;

public interface Queuing extends Queueable {

    default Queueable updateQueue() {
        updateCounter();
        if (getHead() == null) return null;
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
        queuer.setHead(this.getTail());

        if (this.getTail() != null) this.getTail().setTail(queuer);
        if (this.getHead() == null) this.setHead(queuer);
        this.setTail(queuer);
        updateCounter(queuer);
    }

    /**
     * ...
     * dupa
     */
    int getCounter(Queueable queuer);

    int getCounter();

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
     */
    void updateCounter();

    /**
     * ...
     * <p><a href="https://github.com/vitalispopoff/calculator/issues/1">Issue #1</a> : Subtree construction</p>
     * <!--
     * !SSUE#9 : bracketing
     * -->
     * <p><a href="https://github.com/vitalispopoff/calculator/issues/9">Issue #9</a> : Add bracketing</p>
     */
    /*void convertToLocalTree();*/

    int currentPriorityIndex();

//    static void convertToLocalTree(Queueable queue) { }

    default void convertToTree() {
        convertToLocalTree(updateQueue());
    }

    default void convertToLocalTree(Queueable queuer) {

        boolean
                isOperand1AVal = ((Enqueued) queuer).getPriorityIndex() == NodeType.VALUE.ordinal();

        if (isOperand1AVal) {
            Enqueued
                    operand1 = (Enqueued) queuer;
            boolean
                    isOperatorAPas = ((Enqueued) getHead()).getPriorityIndex() == getCounter();

            if (isOperatorAPas) {
                Enqueued
                        operator = (Enqueued) updateQueue();
                boolean
                        isOperand2AVal = ((Enqueued) getHead()).getPriorityIndex() == NodeType.VALUE.ordinal();

                if (isOperand2AVal) {

                    Nodeable
                            opLeft = operand1.unwrap(),
                            opRite = ((Enqueued) updateQueue()).unwrap(),
                            opRoot = operator.getNode();

                    opRoot.setLocalLeft(opLeft);
                    opRoot.setLocalRite(opRite);
                    opRoot.setValue();
                    operator.setPriorityIndex(NodeType.VALUE);


                    if (getHead() == null) updateQueue(operator);
                    else convertToLocalTree(operator);

                } else {
                    boolean
                            isOperand2ABra = ((Enqueued) getHead()).getType() == NodeType.BRACKET_IN;

                    if (isOperand2ABra) {   // convertToLocalQueue()
//                    declare a sub-queue
//                    move the part of the super queue up to the corresponding BRACKET_OUT node to the sub-queue
//                    recursive call of the convertToLocalTree
                    }
                }   // !SSUE#9 : bracketing
            }
        }
    }
}