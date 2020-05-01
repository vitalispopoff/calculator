package calculation;

/**
 * :
 * Nodeable represents a basic element of the equation:
 * a number, an arithmetic operation, a bracket.
 */
public interface Nodeable {

    /*default int getPriority() {
        return Typical.getTypicalPriority(this.getType());
    }*/ // unused - disposable
    /*default int getPriority(){return getType().ordinal()>>1;}*/ // old implementation of the getPriority()

//    @formatter:off

    Nodeable getLocalLeft();
    Nodeable getLocalRoot();
    Nodeable getLocalRite();

    Typical getType();

    Double getValue();

    void setLocalLeft(Nodeable node);
    void setLocalRoot(Nodeable node);
    void setLocalRite(Nodeable node);

    void setType(Typical type);

    void setValue(Double value);
    void setValue();

//  @formatter:on
}