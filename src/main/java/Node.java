public class Node implements Queueable {

    static Queueable
            mainQueue = new Node(null);
    static int[] priorityIndex;
    Queueable
            left,
            rite,
            root;
    Double value = Double.NaN;
    String priority;

    Node(Queueable queueable) {
        setRoot(queueable);
    }

    @Override
    public Queueable updateQueue() {
        Queueable
                cache = mainQueue.getLeft();

        mainQueue.setLeft(cache.getRoot());
        cache.setRoot(null);

        return cache;
    }

    @Override
    public void updateQueue(Queueable queueable) {
        mainQueue.getRite().setRoot(queueable);
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
    public Queueable getRoot() {
        return root;
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
    public void setRoot(Queueable queueable) {
        root = queueable;
    }
}