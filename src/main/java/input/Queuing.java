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

//    static void convertToLocalTree(Queueable queue) { }

    default void convertToTree() {
        constructLocalSubTree(updateQueue());
    }

    default void constructLocalSubTree(Queueable queuer) {

        boolean
//                isOperand1AVal = ((Enqueued) getHead()).getPriorityIndex() == NodeType.VALUE.ordinal();
                isOperand1AVal = ((Enqueued) queuer).getPriorityIndex() == NodeType.VALUE.ordinal();

        if (isOperand1AVal) {
            Enqueued
//                    operand1 = (Enqueued) updateQueue();
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

                    operator.setPriorityIndex(NodeType.VALUE);
//                    updateQueue(operator);
                } else {
                    boolean
                            isOperand2ABra = ((Enqueued) getHead()).getType() == NodeType.BRACKET_IN;

                    if (isOperand2ABra) {
//                    declare a sub-queue
//                    move the part of the super queue up to the corresponding BRACKET_OUT node to the sub-queue
//                    recursive call of the convertToLocalTree
                    }
                    boolean dupa;

                }
            }
       /*
        Enqueued
                operand1 = (Enqueued) updateQueue(),
                operator = (Enqueued) updateQueue(),
                operand2 = (Enqueued) getHead();
        boolean
                isOperand1AVal = operand1.getPriorityIndex() == NodeType.VALUE.ordinal(),
                isOperatorAPas = operator.getPriorityIndex() <= getCounter(),
                isOperand2AVal = operand2.getPriorityIndex() == NodeType.VALUE.ordinal();

        if (isOperand1AVal && isOperatorAPas && isOperand2AVal) {
            operand2 = (Enqueued) updateQueue();

            Nodeable
                    op1Node = operand1.unwrap(),
                    opRNode = operator.getNode(),
                    op2Node = operand2.unwrap();
            operand1 = operand2 = null;

            opRNode.setLocalLeft(op1Node);
            op2Node.setLocalRite(op2Node);
            operator.getNode().setType(NodeType.VALUE);
            return operator;
        }
        return operand2;*/
        }
    }

    /*public static void main(String[] args) {
        Typical
                typ1 = NodeType.VALUE,
                typ2 = NodeType.EXPONENT,
                typ3 = NodeType.VALUE,
                typ4 = NodeType.ADD,
                typ5 = NodeType.VALUE;
        int
                ord1 = typ1.ordinal(),
                ord2 = typ2.ordinal(),
                ord3 = typ3.ordinal(),
                ord4 = typ4.ordinal(),
                ord5 = typ5.ordinal();
        Nodeable
                node1 = typ1.interact(),
                node2 = typ2.interact(),
                node3 = typ3.interact(),
                node4 = typ4.interact(),
                node5 = typ5.interact();
        Enqueued
                que1 = new Queuer(node1),
                que2 = new Queuer(node2),
                que3 = new Queuer(node3),
                que4 = new Queuer(node4),
                que5 = new Queuer(node5);
        Queuing
                Q1 = new NodeQueue(que1);
        Q1.updateQueue(que2);
        Q1.updateQueue(que3);
        Q1.updateQueue(que4);
        Q1.updateQueue(que5);

        Q1.convertToLocalTree();

    }*/ // psvm

}