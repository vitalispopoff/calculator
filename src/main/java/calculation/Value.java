package calculation;

import static java.lang.Double.NaN;

public class Value implements Nodeable {

    Double value = NaN;

    //    @formatter:off
    void setValue(Double value){this.value = value;}
    Double getValue(){return value;}
    //    @formatter:on
}
