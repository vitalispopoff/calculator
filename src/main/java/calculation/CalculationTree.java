package calculation;

public interface CalculationTree {

    static CalculationNode
            root = null;

    static void addAsRoot(){};

    static void addAsLeaf(){};

    static void addAsBranch(){};




    /*
     * + basic tree:
     *   write operand$1 (root)
     *
     *    write operation 1:
     *       set current root as operand$1
     *
     *   write operand$2
     *       set as current root operand$2
     *
     *   write operation 2 :
     *       check operation 2 priority
     *           if higher than operation 1 :
     *               write operation 2 in place of operand$2
     *               move operand$2 as operation 2's operand$1
     *           else
     *               set current root as operand$1
     *               write operation 2 as root
     *
     * + Calculation priority:
     *
     *   exponantiation
     *   roots
     *
     *   multiplication
     *   division
     *
     *   addition
     *   subtraction
     *
     * */

}
