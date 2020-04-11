package input;

/**
 * interface enables sorting single expressions
 * and delivering them to further processing:
 * filtering (TODO - filtering by operation priority)
 * assembling into local trees
 * and executing them (?)
 * reassemlbing into a global tree
 * */
public interface Queueable {

//    void setPrev(Queueable prev);

//    void setNext(Queueable next);

    void addToQueue(Queuer queuer);

    Queueable takeFromQueue();
}