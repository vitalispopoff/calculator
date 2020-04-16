package _temp.calculation;

import static java.lang.Double.NaN;

public abstract class Node implements Nodeable{

    public static Node
            mainRoot = null;
    Node
            localRoot = null,
            localLeft = null,
            localRite = null;
    public Double
            value = NaN;
    public NodeType
            type;

    public Node() {
        setType();
    }

    public Node(double value) {
        this();
        setValue(value);
    }

    public Node(Node left, Node rite) {
        this();
        if (localRoot == null || localRoot == left || localRoot == rite) localRoot = this;
        localLeft = left;
        localRite = rite;
    }

    void setMainRoot() {
        mainRoot = this;
    }

    void resetMainRoot() {
        mainRoot = null;
    }

    void setValue(double value) {
        this.value = value;
    }

    public double setValue() {
        double
                LeftVal = localLeft.valueIsNaN() ? localLeft.setValue() : this.localLeft.value,
                RiteVal = localRite.valueIsNaN() ? localRite.setValue() : this.localRite.value,
                result = this.valueIsNaN() ? calculate(LeftVal, RiteVal) : this.value;
        this.setValue(result);
        return result;
    }

    public double getValue(){
        return value;
    }

    public void setType() {
    }

    public void resetType() {
        this.type = NodeType.VAL;
    }

    public NodeType getType() {
        return type;
    }

    public void setLocalLeft(Node node) {
        localLeft = node;
    }

    public void setLocalRite(Node node) {
        localRite = node;
    }

    boolean valueIsNaN() {
        return ((Double) value).isNaN();
    }

    public double calculate(double left, double rite) {
        return NaN;
    }
}