package calculation;

public interface Nodeable {

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