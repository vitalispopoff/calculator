package input;

import static memory.Memory.*;

import calculation.*;

public interface Queuing extends Queueable {

    default Double convertToTree() {
        if (getHead() == null) return Double.NaN;
        else convertToLocalTree_1(updateQueue());

        Enqueued
                cache = (Enqueued) getHead();
        Nodeable
                nod /*= cache.getNode()*/;
        double
                result /*= nod.getValue()*/;

        return /*result*/ 0.;
    }

    default void convertToLocalTree_1(Queueable queuer) {

        Queueable
                operand1 = mainQueue.getHead() == queuer ? mainQueue.updateQueue() : queuer,
                operand0 = mainQueue.updateQueue(),
                operand2 = mainQueue.updateQueue();
        Nodeable
                branchLeft = ((Enqueued) operand1).unwrap(),
                branchRite = ((Enqueued) operand2).unwrap(),
                root = ((Enqueued) operand0).getNode();

        root.setLocalLeft(branchLeft);
        root.setLocalRite(branchRite);

//        mainQueue.updateQueue(operand0);
    }

    /**
     * <!--
     * !SSUE#9 : bracketing
     * -->
     * <p><a href="https://github.com/vitalispopoff/calculator/issues/9">Issue #9</a> : Add bracketing</p>
     */
    default void convertToLocalTree(Queueable queuer) {

        if (this.getHead() != this.getTail()) {

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

                        if (isOperand2ABra) {
                            System.out.println("loop for the BRACKET_IN");
                            // convertToLocalQueue()
//                    declare a sub-queue
//                    move the part of the super queue up to the corresponding BRACKET_OUT node to the sub-queue
//                    recursive call of the convertToLocalTree
                        } else {
                            System.out.println("completely useless loop for whatever else");

                        }
                    }   // !SSUE#9 : bracketing
                }
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

    /*default*/ Queueable updateQueue(); /*{
        updateCounter();
        if (getHead() == null) return null;
        else {
            Queueable cache = getHead();                        //  copy extracted
            setHead(cache.getTail());                           //  set extracted's follower as a new head
            if (cache.getTail() != null)                        //  if the extracted's follower ain't empty already
                cache.setTail(null);                            //      then set it empty

            if (getHead() == null)                              //  if the updated head is empty
                setTail(null);                                  //      make the tail empty too
            else getHead().setHead(null);                       //  else set new heads precursor to empty

            return cache;
        }
    }*/

    /**
     * <!--
     * !SSUE#11 : simplify counter - move to the NodeType ?
     * -->
     * <p><a href="https://github.com/vitalispopoff/calculator/issues/11">Issue #11</a> : simplify  counter</p>
     * <p>Adds a new queuer to the counters</p>
     */
    void updateCounter(Queueable queuer);

    /**
     * <!--
     * !SSUE#11 : simplify counter - move to the NodeType?
     * -->
     * <p><a href="https://github.com/vitalispopoff/calculator/issues/11">Issue #11</a> : simplify  counter</p>
     * <p>Removes the head queuer from the counters</p>
     */
    void updateCounter();

    int getCounter(Queueable queuer);

    int getCounter();

    int currentPriorityIndex();
}