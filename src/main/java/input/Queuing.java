package input;

import calculation.*;

public interface Queuing extends Queueable {

    /**
     * <!--
     * !SSUE#9 : bracketing
     * -->
     * <p><a href="https://github.com/vitalispopoff/calculator/issues/9">Issue #9</a> : Add bracketing</p>
     * <p><a href="https://github.com/vitalispopoff/calculator/issues/1">Issue #1</a> : Subtree construction [EOT]</p>
     */
    default void convertToTree() {
        convertToLocalTree(updateQueue());
    }

    default void convertToLocalTree(Queueable queuer) {

        boolean
                isOperand1AVal = ((Enqueued) queuer).getPriorityIndex() == NodeType.VALUE.getTypePriority();

        if (isOperand1AVal) {
            Enqueued
                    operand1 = (Enqueued) queuer;
            boolean
                    isOperatorAPas = ((Enqueued) getHead()).getPriorityIndex() == getCounter();

            if (isOperatorAPas) {
                Enqueued
                        operator = (Enqueued) updateQueue();
                boolean
                        isOperand2AVal = ((Enqueued) getHead()).getPriorityIndex() == NodeType.VALUE.getTypePriority();

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

    default void updateQueue(Queueable queuer) {
        queuer.setHead(this.getTail());

        if (this.getTail() != null) this.getTail().setTail(queuer);
        if (this.getHead() == null) this.setHead(queuer);

        this.setTail(queuer);
        updateCounter(queuer);
    }

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

    /**
     * <!--
     * !SSUE#11 : simplify counter - move to the NodeType ?
     * -->
     * <p><a href="https://github.com/vitalispopoff/calculator/issues/11">Issue #11</a> : simplify  counter</p>
     * <p><a href="https://github.com/vitalispopoff/calculator/issues/10">Issue #10 closed</a> : verify testing for the Queuing</p>
     * <p>Updates the counters for the queue:<br>
     * adds a new queuer to the counters</p>
     */
    void updateCounter(Queueable queuer);

    /**
     * <!--
     * !SSUE#11 : simplify counter - move to the NodeType?
     * -->
     * <p><a href="https://github.com/vitalispopoff/calculator/issues/11">Issue #11</a> : simplify  counter</p>
     * <p><a href="https://github.com/vitalispopoff/calculator/issues/10">Issue #10 closed</a> : testing [EOT]</p>
     * <p>Updated the counters for the queue:<br>
     * removes the head queuer from the counters</p>

     */
    void updateCounter();

    int getCounter(Queueable queuer);

    int getCounter();

    int currentPriorityIndex();

}