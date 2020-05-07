public interface Queueable {

    Queueable updateQueue();
    Queueable getLeft();
    Queueable getRite();
    Queueable getRoot();

    void updateQueue(Queueable queueable);
    void setLeft(Queueable queueable);
    void setRite(Queueable queueable);
    void setRoot(Queueable queueable);
}