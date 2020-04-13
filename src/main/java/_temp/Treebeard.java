package _temp;

import calculation.Node;

public abstract class Treebeard {

    static Node
            leftSlot = null,        // TODO disposable
            rootSlot = null,        // TODO disposable
            riteSlot = null;        // TODO disposable
    static boolean
            leftNull = true,        // TODO disposable
            rootNull = true,        // TODO disposable
            riteNull = true;        // TODO disposable

    // TODO disposable
    static boolean setLeftNull() {
        return leftNull = leftSlot == null;
    }

    // TODO disposable
    static boolean setRootNull() {
        return rootNull = rootSlot == null;
    }

    // TODO disposable
    static boolean setRiteNull() {
        return riteNull = riteSlot == null;
    }

    // TODO disposable
    static int identifySlot() {
        if (leftNull) return 0;
        else if (!leftNull && rootNull) return 1;
        else if (!leftNull && !rootNull) return 2;
        else if (!leftNull && !rootNull && !riteNull) return 3;
        else return -1;
    }

    // TODO disposable
    static void setLeftSlot(Node node) {
        leftSlot = node;
        setLeftNull();
    }

    // TODO disposable
    static void setRootSlot(Node node) {
        rootSlot = node;
        setRootNull();
    }

    // TODO disposable
    static void setRiteSlot(Node node) {
        riteSlot = node;
        setRiteNull();
    }
}