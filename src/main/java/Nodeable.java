public interface Nodeable {

    Nodeable takeFromQueue();
    Nodeable getLeft();
    Nodeable getRite();
    Nodeable getRoot();

    void addToQueue(Nodeable nodeable);
    void setLeft(Nodeable nodeable);
    void setRite(Nodeable nodeable);
    void setRoot(Nodeable nodeable);
}