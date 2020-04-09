package input;

public class _InputQueue extends Queuer /*implements Queueable*/ {

    int length = 0;
    Queuer
            head = null,
            tail = null;

    _InputQueue() {
    }

    _InputQueue(Queuer queuer) {
        head = tail = null;
        length++;
    }   // ? TODO input parameter to be switched to Queueable ?

    void addToQueue(Queuer queuer){
        queuer.setPrevious(tail);
        tail = queuer;
        length++;
    }   // ? TODO "joinQueue" ?

    Queueable takeFromQueue(){

    }

}