package calculation;

public interface Typical {

    static int  getTypePriority(NodeType type){return type.ordinal()>>1;}

    int getPriority();
    void interact();
}