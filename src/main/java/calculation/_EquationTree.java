package calculation;

public abstract class _EquationTree {

    static Node
            leftSlot = null,
            rootSlot = null,
            riteSlot = null;
    static boolean
            leftNull = true,
            rootNull = true,
            riteNull = true;

    static boolean setLeftNull() {
        return leftNull = leftSlot == null;
    }

    static boolean setRootNull() {
        return rootNull = rootSlot == null;
    }

    static boolean setRiteNull() {
        return riteNull = riteSlot == null;
    }

    static int identifySlot() {
        if (leftNull) return 0;
        else if (!leftNull && rootNull) return 1;
        else if (!leftNull && !rootNull) return 2;
        else if (!leftNull && !rootNull && !riteNull) return 3;
        else return -1;
    }

    static void setLeftSlot(Node node){
        leftSlot = node;
        setLeftNull();
    }

    static void setRootSlot(Node node){
        rootSlot = node;
        setRootNull();
    }

    static void setRiteSlot(Node node){
        riteSlot = node;
        setRiteNull();
    }
}