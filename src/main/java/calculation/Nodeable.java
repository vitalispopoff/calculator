package calculation;

public interface Nodeable {

    /**
     * Returns an integer representing
     * the priority of the object as an element
     * of the equation.
     * The value is based on the index
     * of the NodeType related to the object;
     * */
    default int getPriority(){return Typical.getTypicalPriority(this.getType());}

    /*default int getPriority(){return getType().ordinal()>>1;}*/   //  old implementation of the getPriority()

    /**
     * Returns left branch of the local tree
     * of which the object is the root
     * */
    Nodeable getLocalLeft();

    /**
     * Returns right branch of the local tree
     * of which the object is the root
     * */
    Nodeable getLocalRite();

    /**
     * Returns the root of the local tree
     * of which the object is one of the branches
     * */
    Nodeable getLocalRoot();

    /**
     * Returns the NodeType of the object
     * */
    Typical getType();

    /**
     * Returns the value of the object
     * (supposed to call calculate()
     * whether the value is NaN)
     * */
    Double getValue();

    /**
     * Sets the NodeType of the object
     * */
    void setType(Typical type);

    /**
     * Sets the left branch of the local tree
     * of which the object is the root
     * */
    void setLocalLeft(Nodeable node);

    /**
     * Sets the root fo the local tree
     * of which the object is one
     * of the branches
     * */
    void setLocalRoot(Nodeable node);

    /**
     * Sets the right branch of the local tree
     * of which the object is the root
     * */
    void setLocalRite(Nodeable node);
}