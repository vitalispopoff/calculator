package calculation;

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
        return (((Enum) this).ordinal())+1;
    }

    default int getTypePriority() throws NullPointerException {
        return (((Enum) this).ordinal())>>1;
    }

    Nodeable interact();

    public static void main(String[] args) {
        NodeType dupa = NodeType.BRACKET_IN;
        System.out.println(dupa.getTypePriority());

    }
}