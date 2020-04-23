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
    public void addToPriorityTypes(Queueable queuer){
        int index = queuer.getNodeTypeOrdinal();
        priorityTypes[index]++;
    }

    @Override
    public void removeFromPriorityTypes(){
        int index = prevOne.getNodeTypeOrdinal();
        priorityTypes[index]--;
    }

    @Override public void addToQueue(Queueable queuer) {
        postOne.setPostOne(queuer);
        queuer.joinQueue(this);
        setPostOne(queuer);
        addToPriorityTypes(queuer);
    }


    @Override
    public Queueable removeFromQueue() {
        removeFromPriorityTypes();
        Queueable result = prevOne;
        prevOne.getPostOne().setPrevOne(null);
        prevOne.setPostOne(null);
        prevOne = prevOne.getPostOne();
        return result;
    }


    /*void convertToLocalTree() {

        if (prevOne.getNodeTypeOrdinal() == NodeType.VALUE.ordinal()
                && this.getNodeTypeOrdinal() == prevOne.getPostOne().getNodeTypeOrdinal()) {
            Nodeable cacheLeft =

        }


    }*/

//    @formatter:off

//    @formatter:on
}