package calculation;

public abstract class Node implements Nodeable {

    static Node globalRoot;
    Node
            localLeft = null,
            localRoot = null,
            localRite = null;

    public Node() {
    }
}