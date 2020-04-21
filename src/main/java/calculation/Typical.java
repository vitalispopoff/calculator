package calculation;

public interface Typical {

    static int getTypicalPriority(Typical type) {
        int cache = type.ordinal();
        return cache >= 0 ? cache >> 1 : cache;
    }

    default int ordinal() {
        try {
            return ((Enum) this).ordinal();
        } catch (Exception e) {
            return -1;
        }
    }
    
    int getPriority();

    Nodeable interact();
}