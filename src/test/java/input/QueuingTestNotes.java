package input;

public interface QueuingTestNotes {


    /**
     * <!--!SSUE#10-->
     * <p><a href="https://github.com/vitalispopoff/calculator/issues/10">Issue #10</a> : verify testing for the Queuing > updateQueue()</p>
     */
    void updateQueue_issue();

    /**
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
     *  <ol start="9"><li>queue returns null, no additional action.</li></ol>
     */
    void updateQueue_Ext_initial();
}
