public class Node implements Queueable {

    static Queueable
            mainQueue = new Node(null);
    Queueable
            left,
            rite,
            follower;

    Node(Queueable queueable) {
        setFollower(queueable);
    }

    @Override
    public Queueable updateQueueable() {
        Queueable
                cache = mainQueue.getLeft();

        mainQueue.setLeft(cache.getFollower());
        cache.setFollower(null);

        return cache;
    }

    @Override
    public void updateQueueable(Queueable queueable) {
        mainQueue.getRite().setFollower(queueable);
        mainQueue.setRite(queueable);
    }

    @Override
    public Queueable getLeft() {
        return left;
    }

    @Override
    public Queueable getRite() {
        return rite;
    }

    @Override
    public Queueable getFollower() {
        return follower;
    }

    @Override
    public void setLeft(Queueable queueable) {
        left = queueable;
    }

    @Override
    public void setRite(Queueable queueable) {
        rite = queueable;
    }

    @Override
    public void setFollower(Queueable queueable) {
        follower = queueable;
    }
}