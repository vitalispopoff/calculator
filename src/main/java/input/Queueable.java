package input;

import calculation.Value;

public interface Queueable {

    //    @formatter:off

    Queueable getTail();
    Queueable getHead();
    void setTail(Queueable tail);
    void setHead(Queueable head);

    //    @formatter:on
}