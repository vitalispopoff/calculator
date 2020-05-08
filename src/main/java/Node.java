public class Node implements Queueable {

    static Queueable
            mainQueue = new Node(null),
            cache;

    static int[] priorityIndex = new int[Priority.values().length];
    Queueable
            left,
            rite,
            root;
    Double
            value = Double.NaN;
    Priority
            priorityType;

//\\ constructors \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    Node(Queueable queueable) {
        setRoot(queueable);
    }

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    static void updatePriorityIndex(Queueable queueable) {
        int
                index = ((Node)queueable).priorityType.ordinal() >> 1;

        priorityIndex[index]++;
    }

    void updatePriorityIndex(){
        int
                index = priorityType.ordinal()>>1;
        priorityIndex[index]--;
    }

    static int getPriorityIndex() {
        int
                index = 0;

        for (int i : priorityIndex) {
            if (i == 0) index++;
            else return index;
        }
        return index;
    }

    void setValue(Double value) {
        this.value = value;
    }

    Double getValue() {
        return value;
    }

//\\ @Overrides //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    @Override
    public Queueable updateQueue() {
        Queueable
                cache = mainQueue.getLeft();

        mainQueue.setLeft(cache.getRoot());
        if(mainQueue.getLeft()==null)mainQueue.setRite(null);
        cache.setRoot(null);

        return cache;
    }

    @Override
    public void updateQueue(Queueable queueable) {
        if (getLeft() == null) setLeft(queueable);
        if (getRite() != null) getRite().setRoot(queueable);
        setRite(queueable);
        updatePriorityIndex();
        ((Node)queueable).updatePriorityIndex();
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