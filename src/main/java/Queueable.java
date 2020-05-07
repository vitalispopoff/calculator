public interface Queueable {

    Queueable updateQueueable();
    Queueable getLeft();
    Queueable getRite();
    Queueable getFollower();

    void updateQueueable (Queueable queueable);
    void setLeft(Queueable queueable);
    void setRite(Queueable queueable);
    void setFollower(Queueable queueable);
}