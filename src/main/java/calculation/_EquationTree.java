package calculation;

public abstract class _EquationTree {

    static Node
            temporalRoot,
            temporalLeft = new Value(),
            temporalRite = new Value();

    public static void readNode(Node node) {

    }
}

/**
 * 1) initializing new tree
 * 2) storing trees
 * 3) storing key branches of trees
 * <p>
 * <p>
 * case :
 * <p>
 * = 1 + 2 * 3 V 4 / 5 - 6 ^ 7
 * <p>
 * = 1 + 2 *(3 V 4)/ 5 -(6 ^ 7)
 * <p>
 * = 1 +(2 *(3 V 4)/ 5)-(6 ^ 7)
 * <p>
 * <p>
 * 1 + 2 * 3 V 4 / 5 - 6 ^ 7
 * <p>
 * 1 + 2 * a / 5 - b   : a = 3 V 4
 * <p>
 * 1 + c / d - b
 * <p>
 * 1 + e - b
 * <p>
 * f - b
 * <p>
 * g
 * <p>
 * 1 + 2 * 3 V 4 / 5 - 6 ^ 7
 * <p>
 * 1 + 2 * a / 5 - b   : a = 3 V 4
 * <p>
 * 1 + c / d - b
 * <p>
 * 1 + e - b
 * <p>
 * f - b
 * <p>
 * g
 */

/**
 *  1 + 2 * 3 V 4 / 5 - 6 ^ 7
 *
 *  1 + 2 * a / 5 - b   : a = 3 V 4
 *
 *  1 + c / d - b
 *
 *  1 + e - b
 *
 *  f - b
 *
 *  g
 *
 * */