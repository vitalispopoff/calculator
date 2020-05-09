public class Node implements Nodeable {

    static Nodeable
            mainQueue = new Node(null),
            cache;

    static int[] priorityIndex = new int[Priority.values().length];
    Nodeable
            left,
            rite,
            root;
    Double
            value = Double.NaN;
    Priority
            priorityType;

//\\ constructors \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    Node(Nodeable nodeable) {
        setRoot(nodeable);
    }

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    void addToPriorityIndex(Nodeable nodeable) {
        int
                index = ((Node) nodeable).priorityType.ordinal() >> 1;
        priorityIndex[index]++;
    }

    void takeFromPriorityIndex(Nodeable nodeable) {
        int
                index = ((Node) nodeable).priorityType.ordinal() >> 1;
        if (priorityIndex[index] > 0) priorityIndex[index]--;
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
    public Nodeable takeFromQueue() {
        Nodeable
                cache = mainQueue.getLeft();

        mainQueue.setLeft(cache.getRoot());
        if (mainQueue.getLeft() == null) mainQueue.setRite(null);
        cache.setRoot(null);
        ((Node) mainQueue).takeFromPriorityIndex(cache);

        return cache;
    }

    @Override
    public void addToQueue(Nodeable nodeable) {
        if (getLeft() == null) setLeft(nodeable);
        if (getRite() != null) getRite().setRoot(nodeable);
        setRite(nodeable);
        ((Node) mainQueue).addToPriorityIndex(nodeable);
    }

    @Override
    public Nodeable getLeft() {
        return left;
    }

    @Override
    public Nodeable getRite() {
        return rite;
    }

    @Override
    public Nodeable getRoot() {
        return root;
    }

    @Override
    public void setLeft(Nodeable nodeable) {
        left = nodeable;
    }

    @Override
    public void setRite(Nodeable nodeable) {
        rite = nodeable;
    }

    @Override
    public void setRoot(Nodeable nodeable) {
        root = nodeable;
    }
}