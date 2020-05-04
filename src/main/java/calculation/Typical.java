package calculation;

import gui.MainPanel;
import input.*;
import memory.Memory;

import static calculation.NodeType.*;
import static memory.Memory.*;

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

    /**
     * <!---->
     * <p>delivers an ordinal() method from the Enum class
     * to the interface<br>
     * accepts enum only.</p>
     */
    default int ordinal() throws NullPointerException {
        return (((Enum) this).ordinal()) + 1;
    }

    default int getTypePriority() throws NullPointerException {
        return ordinal() >> 1;
    }

    /**
     * <!---->
     * <p>Links contracted interaction with calculation types defined by Nodeable</p>
     */
    Nodeable interact();

    /**
     * <!---->
     * <p>Provides contract for the implementation of the button action.
     * Delivers additional logic for the action context.</p>
     */
    static void interact(Typical type, char symbol) {
        Double
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
                node = type.interact();

                if (type != EVALUATE) {
                    queuer = new Queuer(node);
                    mainQueue.updateQueue(queuer);
//                mainQueue.updateQueue(new Queuer(type.interact()));
                }
            }
        }
    }