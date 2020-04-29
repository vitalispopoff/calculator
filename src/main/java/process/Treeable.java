package process;

import calculation.*;
import input.*;

public interface Treeable extends Queuing, _Treeable_Notes {

    void treeable();

    default void convertToLocalTree(Queueable operand1) {

        Queueable
//                operand1 = updateQueue(),
                operator = updateQueue(),
                operand2;
        boolean
                isOperand1Val = ((Queuer) operand1).getType() == NodeType.VALUE,
                isOperatorACurrentPriority = ((Queuer) operator).getPriorityIndex() >= currentPriorityIndex();

        if (isOperand1Val && isOperatorACurrentPriority) {
            operand2 = updateQueue();

            boolean
                    isOperand2Val = ((Queuer) operand2).getType() == NodeType.VALUE;

            if (isOperand2Val) {
                Nodeable
                        opLeft = ((Enqueued) operand1).deQueuer(),
                        opRite = ((Enqueued) operand2).deQueuer(),
                        opRoot = ((Enqueued) operator).getNode();
                opRoot.setLocalLeft(opLeft);
                opRoot.setLocalRite(opRite);
                opRoot.setValue();

                operand1 = operator;
                operator = operand2 = null;
                convertToLocalTree(operand1);

            } else if (((Queuer)operand2).getType() == NodeType.BRACKET_IN){/*...brackets...*/}
        }
        updateQueue(operand1);
        updateQueue(operator);
    }


}