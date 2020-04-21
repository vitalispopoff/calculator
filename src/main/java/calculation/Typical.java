package calculation;


/**
 * :
 * Typical represents a type of a Nodeable
 * in order to support connecting Nodeable with GUI
 * */
public interface Typical {

    /**
     * :
     * returns a integer representation of a Typical priority level
     * in terms of processing order of the equation
     * */
    static int getTypicalPriority(Typical type) {
        int cache = type.ordinal();
        return cache >= 0 ? cache /*>> 1*/ : cache;
    }

    static Typical valueOf(Typical type) { return type;}

    /**
     * :
     * returns the priority of the Typical
     * */
//    int getPriority();

    /**
     * :
     * delivers an ordinal() method from the Enum class
     * to the interface
     * */
    default int ordinal() {
        try {
            return ((Enum) this).ordinal();
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * :
     * enables the Typical to cooperate with GUI
     * */
    Nodeable interact();
}