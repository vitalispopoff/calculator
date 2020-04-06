package calculation;

import static java.lang.Double.NaN;

public abstract class Node {

    //    @formatter:off
    static Node
            mainRoot = null;
    Node
            localRoot = null,
            localLeft = null,
            localRite = null;
    double value = NaN;

    public Node() {}
    public Node(double value) {setValue(value);}
    public Node(Node left, Node rite) {
        if (localRoot == null || localRoot == left || localRoot == rite) localRoot = this;
        localLeft = left;
        localRite = rite;
    }

    void setMainRoot(){mainRoot = this;}

    void setValue(double value) {this.value = value;}
    public double setValue() {
        double
                LeftVal = localLeft.valueIsNaN() ? localLeft.setValue() : this.localLeft.value,
                RiteVal = localRite.valueIsNaN() ? localRite.setValue() : this.localRite.value,
                result = this.valueIsNaN() ? calculate(LeftVal, RiteVal) : this.value;
        this.setValue(result);
        return result;
    }

//    formatter:on

    boolean valueIsNaN() {
        return ((Double) value).isNaN();
    }

    public double calculate(double left, double rite) {
        return NaN;
    }

}