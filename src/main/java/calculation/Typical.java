package calculation;

import gui.Button;

/**
 * <!---->
 * <p>Typical represents a type of a Nodeable
 * in order to support connecting Nodeable with GUI.</p>
 * <p>Addistional resources:</p>
 * <ol>
 *  <li><a href="https://stackoverflow.com/questions/18883646/java-enum-methods">java enum methods</a> (StackOverflow)</li>
 *  <li><a href="https://www.developer.com/java/data/seven-ways-to-refactor-java-switch-statements.html">refactoring the SWITCH</a></li>
 *  </ol>
 */
public interface Typical {

    default int ordinal() throws NullPointerException {
        return (((Enum) this).ordinal());
    }

    default int getTypePriority() throws NullPointerException {
        return ordinal() >> 1;
    }

    void interact(Button button);


 /*   static void interact(Typical type, char symbol) {
        double
                val;
        Nodeable
                node;
        Enqueued
                queuer;

        if (type.getTypePriority() == VALUE.getTypePriority()) {
            addToParserCache(symbol);
        } else {
            if (isParserCacheAValue()) {
                val = Memory.clearCache();
                node = new Value(VALUE, val);
                queuer = new Queuer(node);

                mainQueue.updateQueue(queuer);
            }
//                node = type.interact();

            if (type != EVALUATE) {
//                    queuer = new Queuer(node);
//                    mainQueue.updateQueue(queuer);
//                mainQueue.updateQueue(new Queuer(type.interact()));
            }
        }
    }*/
}