package input;

import calculation.*;

public class NodeQueue extends Queuer implements Queuing {

    int[] priorityTypes;
    int length = 0;

    public NodeQueue(Queueable queuer) {
        setPriorityTypes();
        addToPriorityTypes(queuer);
        prevOne = postOne = queuer;
        length++;
    }

    public void setPriorityTypes() {
        this.priorityTypes = new int[NodeType.values().length];
    }

    @Override
    public void addToPriorityTypes(Queueable queuer) {
        int index = queuer.getNodeTypeOrdinal();
        priorityTypes[index]++;
    }

    @Override
    public void removeFromPriorityTypes() {
        int index = prevOne.getNodeTypeOrdinal();
        priorityTypes[index]--;
    }

    @Override
    public void addToQueue(Queueable queuer) {
        postOne.setPostOne(queuer);
        queuer.joinQueue(this);
        setPostOne(queuer);
        addToPriorityTypes(queuer);
        length++;
    }

    @Override
    public Queueable removeFromQueue() {
        removeFromPriorityTypes();
        Queueable result = prevOne;
        prevOne.getPostOne().setPrevOne(null);
        prevOne.setPostOne(null);
        prevOne = prevOne.getPostOne();
        length--;
        return result;
    }

    @Override
    public void convertToLocalTree() {
        /*boolean
                truth,
                isPrevOneValue
                        = prevOne.getNodeTypeOrdinal()
                        == NodeType.VALUE.ordinal(),
                isCurrentLocalTreePrioritized
                        = this.getNodeTypeOrdinal()
                        == prevOne.getPostOne().getNodeTypeOrdinal();*/

        if (isPrevOneValue() && isCurrentLocalTreePrioritized()) {
            Nodeable
                    cacheLeftNode = removeFromQueue().deQueuer(),
                    cacheRootNode;
            Queueable
                    cacheLeft = new NodeQueue(new Queuer(cacheLeftNode)),
                    cacheRoot = removeFromQueue(),
                    cacheRite;
            cacheRootNode = cacheRoot.getNode();
            cacheRite = isPrevOneValue() ? removeFromQueue() : null;

            {/* . // TODO : null refers to the brackets - recursion -  . */}

            cacheRoot.setPrevOne(cacheLeft);
            cacheRootNode.setLocalRite(cacheRite.getNode());
            cacheRootNode.setValue();       // TODO reimplement setValue
            addToQueue(cacheRoot);
        } else rebuffLocalTreeNodes();
        {/*for (int i = 0; i < 2; i++) addToQueue(removeFromQueue());*/}
    }

    private boolean isPrevOneValue() {
        return prevOne.getNodeTypeOrdinal() == NodeType.VALUE.ordinal();
    }

    private boolean isCurrentLocalTreePrioritized() {
        return this.getNodeTypeOrdinal() == prevOne.getPostOne().getNodeTypeOrdinal();
    }

    private void rebuffLocalTreeNodes(){
        for (int i = 0; i < 2; i++) addToQueue(removeFromQueue());
    }
}