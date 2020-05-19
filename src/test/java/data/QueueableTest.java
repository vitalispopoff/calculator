package data;

import logic.Type;
import org.junit.*;

import static data.Queueable.mainQueueable;

public class QueueableTest {

//	@formatter:off

	static Queueable Q1, Q2;

	@Before
	public void initial() {
		Q1 = new Queueable.MainQueue ();
		mainQueueable.setHead (null);
		mainQueueable.setTail (null);
	}

	@Test public void Queueable_01() { Assert.assertNull( mainQueueable.getHead() ); }
	@Test public void Queueable_02() { Assert.assertNull( mainQueueable.getTail() ); }

//	defaults  \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	private void add_initial_1() { mainQueueable.add( Q1 ); }

	@Test public void add_01() {
		add_initial_1();
		Assert.assertSame( Q1, mainQueueable.getHead() );
	}
	@Test public void add_02() {
		add_initial_1();
		Assert.assertSame( Q1, mainQueueable.getTail() );
	}

	private void add_initial_2() {
		Q2 = new Queueable.MainQueue();
		mainQueueable.add( Q1 );
		mainQueueable.add( Q2 );
	}

	@Test public void add_03() {
		add_initial_2();
		Assert.assertSame( Q1, mainQueueable.getHead() );
	}
	@Test public void add_04() {
		add_initial_2();
		Assert.assertSame( Q2, mainQueueable.getTail() );
	}
	@Test public void add_05() {
		add_initial_2();
		Assert.assertSame( Q1, Q2.getHead() );
	}
	@Test public void add_06() {
		add_initial_2();
		Assert.assertSame( Q2, Q1.getTail() );
	}

	@Test public void remove_00() { Assert.assertNull( mainQueueable.remove() ); }
	@Test public void remove_01() {
		add_initial_1();
		Assert.assertSame( Q1, mainQueueable.remove() );
	}
	@Test public void remove_02() {
		add_initial_1();
		mainQueueable.remove();
		Assert.assertNull( mainQueueable.getHead() );
	}
	@Test public void remove_03() {
		add_initial_1();
		mainQueueable.remove();
		Assert.assertNull( mainQueueable.getTail() );
	}
	@Test public void remove_04() {
		add_initial_2();
		mainQueueable.remove();
		Assert.assertSame( Q2, mainQueueable.getHead() );
	}
	@Test public void remove_05() {
		add_initial_2();
		mainQueueable.remove();
		Assert.assertSame( Q2, mainQueueable.getTail() );
	}

	@Test public void isHollow_01() { Assert.assertTrue( mainQueueable.isHollow() ); }
	@Test public void isHollow_02() {
		mainQueueable.add( Q1 );
		Assert.assertFalse( mainQueueable.isHollow() );
	}

	@Test public void isSingle_01() { Assert.assertFalse( mainQueueable.isSingle() ); }
	@Test public void isSingle_02() {
		mainQueueable.add( Q1 );
		Assert.assertTrue( mainQueueable.isSingle() );
	}

//	MainQueue \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Test public void getTypeIndex_01(){
		Assert.assertEquals(10,mainQueueable.getTypeIndex());
	}

	@Test public void typeIndex_01(){
		mainQueueable.addType(mainQueueable);
		Assert.assertEquals(9>>1, mainQueueable.getTypeIndex());
	}
	@Test public void typeIndex_02(){
		Node node = new Node();
		node.setType(Type.VALUE);
		mainQueueable.addType(mainQueueable);
		mainQueueable.addType(node);
		Assert.assertEquals(9>>1, mainQueueable.getTypeIndex());
	}

	@Test public void removeIndex_01(){
		mainQueueable.addType(mainQueueable);
		mainQueueable.removeType(mainQueueable);
		Assert.assertEquals(10, mainQueueable.getTypeIndex());
	}

	//	@formatter:on

}