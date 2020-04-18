package calculation;

public interface Nodeable {

    Double getValue();
    Nodeable getLocalLeft();
    Nodeable getLocalRite();
    Nodeable getLocalRoot();

    NodeType getType();

    int getTypePriority();
}