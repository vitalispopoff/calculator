package input;

import calculation.NodeType;

public class CalculationQueue extends Queuer {

    int[] queuerNodeTypes;
    int length = 0;

    CalculationQueue(Queueable queuer) {
        this.queuerNodeTypes = new int[NodeType.values().length >> 1];
        queuerNodeTypes[queuer.getNodeTypeOrdinal() >> 1]++;
        prevOne = nextOne = queuer;
        length++;
    }


    //    @formatter:off
    int getLength(){return length;}
    //  @formatter:on
}