package data;

import org.junit.*;

public class QueueableTest {

//	@formatter:off

	static Queueable Q1, Q2, Q3;

	@Before public void initial () {
		Q1 = new Queue2();
	}

	@Test public void Queueable_01 () { Assert.assertNull (Q1.getHead()); }
	@Test public void Queueable_02 () { Assert.assertNull (Q1.getTail()); }

//	defaults  \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	private void add_initial_1 () {
		Q2 = new Queue2 ();
		Q2.add (Q1);
	}

	@Test public void add_01 () {
		add_initial_1();
		Assert.assertSame (Q1, Q2.getHead ());
	}
	@Test public void add_02 () {
		add_initial_1();
		Assert.assertSame (Q1, Q2.getTail ());
	}

	private void add_initial_2(){
		Q2 = new Queue2 ();
		Q3 = new Queue2 (Q1);
		Q3.add (Q2);
	}

	@Test public void add_03 () {
		add_initial_2();
		Assert.assertSame (Q1, Q3.getHead ());
	}
	@Test public void add_04 () {
		add_initial_2();
		Assert.assertSame (Q2, Q3.getTail ());
	}
	@Test public void add_05 () {
		add_initial_2();
		Assert.assertSame (Q1, Q2.getHead ());
	}
	@Test public void add_06 () {
		add_initial_2();
		Assert.assertSame (Q2, Q1.getTail ());
	}

	@Test public void remove_00 () { Assert.assertNull(Q1.remove()); }
	@Test public void remove_01 () {
		add_initial_1 ();
		Assert.assertSame (Q1, Q2.remove ());
	}
	@Test public void remove_02 () {
		add_initial_1 ();
		Q2.remove ();
		Assert.assertNull (Q2.getHead ());
	}
	@Test public void remove_03 () {
		add_initial_1 ();
		Q2.remove ();
		Assert.assertNull (Q2.getTail ());
	}
	@Test public void remove_04 () {
		add_initial_2();
		Q3.remove ();
		Assert.assertSame(Q2, Q3.getHead());
	}
	@Test public void remove_05 () {
		add_initial_2();
		Q3.remove ();
		Assert.assertSame(Q2, Q3.getTail());
	}

	@Test public void isHollow_01 () { Assert.assertTrue (Q1.isHollow ()); }
	@Test public void isHollow_02 () {
		Q2 = new Queue2 (Q1);
		Assert.assertFalse (Q2.isHollow( ));
	}

	@Test public void isSingle_01 () { Assert.assertFalse (Q1.isSingle ()); }
	@Test public void isSingle_02 () {
		Q2 = new Queue2 (Q1);
		Assert.assertTrue (Q2.isSingle ());
	}

	//	@formatter:on
}