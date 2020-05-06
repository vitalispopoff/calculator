package calculation;

import static memory.Memory.*;
import static calculation.NodeType.*;

import calculation.otherExpressions.Value;
import input.*;
import memory.Memory;

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

    static void dumpParserCache() {
        Memory.dumpParserCache();
        /*System.out.println("dupa");
        if (isParserCacheAValue()) {
            double
                    val = clearCache();
            Nodeable
                    nod = new Value(VALUE, val);
            Queueable
                    queuer = new Queuer(nod);
            mainQueue.updateQueue(queuer);

            System.out.println("dumpParserCache() : the value added to the mainQueue");
        } else System.out.println("dumpParserCache() : no value to add to the mainQueue");*/
    }
}