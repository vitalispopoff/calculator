package input;

public interface _QueuingTestNotes {

    /**
     * ...
     * <p><a href="https://github.com/vitalispopoff/calculator/issues/10">Issue #10 closed</a> : verify testing for the Queuing > updateQueue()</p>
     */
    void _issue_10();

    /**
     * ...
     * <p>updateQueue() - extractor test:</p>
     * <p><a href="https://github.com/vitalispopoff/calculator/issues/10">Issue #10</a>:
     * <a href="https://github.com/vitalispopoff/calculator/issues/10#issuecomment-620499308">subroutine</a></p>
     * <p><b>initial: queue Q1 contains: que1(head), que2(tail)</b></p>
     *  <ol>
     *      <li>method returns que1</li>
     *      <li>queue reports que2 as its head</li>
     *      <li>queue new head is to be null</li>
     *      <li>old head tail is to be null</li>
     *      <li><i>counter - to be tested in the context after its own tests</i></li></ol>
     * <p><b>extraction of the last queuer</b></p>
     *  <ol start="6">
     *      <li>queue head is empty (null)</li>
     *      <li>queue tail is empty (null)</li>
     *      <li><i>counter is all 0 - to be tested in the context after its own tests</i></li></ol>
     * <p><b>extraction from an empty queue</b></p>
     *  <ol start="10"><li>queue returns null, no additional action.</li></ol>
     */
    void updateQueue_Ext_initial();

    /**
     * ...
     * <p>updateQueue() - extractor test:</p>
     * <p><a href="https://github.com/vitalispopoff/calculator/issues/10">Issue #10</a>:
     * <a href="https://github.com/vitalispopoff/calculator/issues/10#issuecomment-620652495">subroutine</a></p>
     * <p><b>initial: queue Q1 contains: que1</b></p>
     *  <ol>
     *      <li>the queuer's head is theQueue tail</li>
     *      <li>Queue's old tail's tail is the queuer</li>
     *      <li>Queue sets its tail to the queuer</li>
     *      <li>the counter is updated</li>
     *  </ol>
     *  <p><b>adding to an empty list</b></p>
     *  <ol start ="5>
     *      <li>the queuer's head is empty</li>
     *      <li>the queuer's tail is empty</li>
     *      <li>the Queue's head is queuer</li>
     *      <li>the Queue's tail is queuer</li>
     *      <li>the counter is one</li>
     *      </ol>
     */
    void updateQueue_Add_initial();

    /**
     * ...
     * <p>returns from the counter the value related to the priority of the node wrapped in queuer.</p>
     * <p>Initial sets a given value (val) to a specified index (ord)<br>
     *     <b>Initial queue with a single queuer;</b>
     * </p>
     *  <ol>
     *      <li>method returns a counter value for the queue head</li>
     *  </ol>
     * */
    void getCounter_initial(int ord, int val);

    /**
     * ...
     * <p>updateCounter(...) - adder test:</p>
     * <p><b>initial: single entity queue</b></p>
     * <ol>
     *     <li>after using the method, the called getCounter returns proper values: 1 for the queue head</li>
     * </ol>
     * */
    void updateCounter_Add_initial();

    /**
     * ...
     * <p>updateCounter() - extractor test:</p>
     * <p><b>initial: single entity queue</b></p>
     * <ol>
     *     <li>counter set to proper values, after using the method, the called getCounter returns 0 for the queue head</li>
     *     <li>counter is 0, after usinge the method, the called getCounter returns 0 for the queue head</li>
     * </ol>
     * */
    void updateCounter_Ext_initial();

//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

    /**
     * <p>setHead tests:</p>
     * <ol start=0">
     * <li>constructor sets head</li>
     * <li>setter sets head</li>
     * <li>setter sets null</li>
     *     </ol>
     */
    void setHead_initial();

    /**
     * <p>getHead tests:</p>
     * <ol>
     * <li>get as default cast</li>
     * <li>get as Queueable cast</li>
     * <li>get as Queuing cast</li>
     * <li>get as NodeQueue cast</li>
     * <li>get as NodeQueue cast</li>
     *     </ol>
     */
    void getHead_initial();

    /**
     * <p>setTail tests:</p>
     * <ol>
     * <li>constructor sets tail</li>
     * <li>setter sets tail</li>
     * <li>setter sets null</li>
     *     </ol>
     */
    void setTail_initial();

    /**
     * <p>getTail tests:</p>
     * <ol>
     * <li>get as default cast</li>
     * <li>get as Queueable cast</li>
     * <li>get as Queuing cast</li>
     * <li>get as NodeQueue cast</li>
     * <li>get as NodeQueue cast</li>
     *     </ol>
     */
    void getTail_initial();
}