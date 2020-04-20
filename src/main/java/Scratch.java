import calculation.NodeType;
import calculation.Nodeable;
import input.*;

class Scratch {

    public static void main(String[] args) {
//        currentPriority_01_scratch();
//        currentPriority_01_scratch_1();
    }

    static Nodeable currentPriority_01_scratch() {
        NodeType type = NodeType.VALUE;
        Nodeable n1 = (NodeType.valueOf(type.toString()).interact());
        System.out.println(n1.getType());
        System.out.println(n1.getType().ordinal() >> 1);
//        System.out.println(n1.getType().ordinal() >> 1 == type.ordinal() >> 1);
        return n1;
    }

    static void currentPriority_01_scratch_1() {
        Nodeable node = currentPriority_01_scratch();
        Queueable
                q1 = new Queuer(node),
                Q1 = new CalculationQueue(q1);
//        System.out.println(((CalculationQueue) Q1).currentPriority());

//
        for (int i : ((CalculationQueue)Q1).queuerNodeTypes) {
            System.out.println("queuerNodeTypes: "+ i);
        }
    }
}