package input;

import calculation.Node;
import calculation.NodeType;

public class _InputQueue extends Queuer {

    int length = 0;                                                                                                     // TODO may be disposable ?
    int[] enlistedNodeTypes;

    _InputQueue(Queuer queuer) {
        this.enlistedNodeTypes = new int[NodeType.values().length];
        enlistedNodeTypes[queuer.getNodeTypeOrdinal()]++;
        prev = next = queuer;
        length++;
    }

    public int getLength() {
        return length;
    }

    double solveEquation() {

        return 0.;
    }


    //    @Formatter:off
    void convertToLocalTree() {

        if (isPrevANumber() && isLocalTreePriorityValid()) {                            //  ? the 1st is a number, and 2nd is prioritized calculation

            Node cacheLeft = ((Queuer) takeFromQueue()).deQueuer();                     // * left branch
            Queuer cacheRoot = (Queuer) takeFromQueue();                                // * local root
            Node cacheRootNode = cacheRoot.getNode();                                   // * local root node
            Queueable cacheRite = isPrevANumber() ? (Queuer) takeFromQueue() : null;    // ! null is bracket FIXME

            {/*...*/}                                                                   // ! null => need to calc TODO

            cacheRootNode.setLocalLeft(cacheLeft);                                      // * attach left branch
            cacheRootNode.setLocalRite(((Queuer) cacheRite).getNode());                 // * attach rite branch
            cacheRootNode.setValue();                                                   // * calc local root
            addToQueue(cacheRoot);                                                      // * adding local tree to queue
        }
        else for (int i = 0; i < 2; i++)                                                // ? neither 1st nor 2nd are prioritized
            this.addToQueue((Queuer) this.takeFromQueue());                             // * both moved at the end of the queue

        if (isPrevLastInEquation()) this.addToQueue((Queuer) this.takeFromQueue());     //  ? both 1st and 2nd are numbers
    }                                                                                   //    @Formatter:on

    private boolean isPrevANumber() {
        return prev.getNodeTypeOrdinal() == NodeType.VAL.ordinal();
    }

    private boolean isLocalTreePriorityValid() {
        return this.getNodeTypeOrdinal() == prev.next.getNodeTypeOrdinal();
    }

    private boolean isPrevLastInEquation() {
        return prev.getNodeTypeOrdinal()
                == NodeType.VAL.ordinal()
                && prev.next.getNodeTypeOrdinal()
                == NodeType.VAL.ordinal();
    }



    @Override
    public void addToQueue(Queuer queuer) {
        enlistedNodeTypes[queuer.getNodeTypeOrdinal()]++;
        queuer.setPrev(next);
        next = queuer;
        length++;
    }

    @Override
    public Queueable takeFromQueue() {
        if (length == 0) return null;
        else {
            Queuer cache = prev;
            prev = prev.leaveQueue();
            enlistedNodeTypes[cache.getNodeTypeOrdinal()]--;
            length--;
            return cache;
        }
    }

    @Override
    public int getNodeTypeOrdinal() {
        int
                cache = 0,
                i = -1;
        while (cache == 0)
            cache = enlistedNodeTypes[++i];
        return i;
    }

    //    @Formatter:off
    @Override public Queuer leaveQueue(){return null;}
    //    @Formatter:on
}