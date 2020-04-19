package calculation;

public interface Nodeable {

    Double getValue();

    Nodeable getLocalLeft();

    Nodeable getLocalRite();

    Nodeable getLocalRoot();

    NodeType getType();

    int getTypePriority();

    void setLocalLeft(Nodeable node);

    void setLocalRoot(Nodeable node);

    void setLocalRite(Nodeable node);
}