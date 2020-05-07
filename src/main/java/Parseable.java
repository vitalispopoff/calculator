public interface Parseable {

    void addToValueCache(char c);
    void toggleValueSign();
    double dumpValueCache();
}