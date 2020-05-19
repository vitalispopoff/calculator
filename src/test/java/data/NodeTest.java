package data;

import logic.Type;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static data.Queueable.mainQueueable;

public class NodeTest {

//	@formatter:off

	static Node n1, n2, n3;

	@Before public void initial(){
		mainQueueable.setHead(null);
		mainQueueable.setTail(null);
		n1 = new Node();
		n2 = new Node();
		n3 = new Node();
		n1.setType(Type.VALUE);
		n2.setType(Type.SUBTRACT);
		n3.setType(Type.VALUE);
		n1.setValue(1.);
		n3.setValue(1.);
	}

	@Test public void Node_01(){
		mainQueueable.add(n1);
		mainQueueable.add(n2);
		mainQueueable.add(n3);
		Assert.assertSame(n3, n2.getRoot());
	}

	@Test public void solve_01() {
		n2.setLeft(n1);
		n2.setRite(n3);
		Assert.assertEquals(0., n2.solve(), 0.);

	}

	@Test public void setValue_01(){
		n2.setLeft(n1);
		n2.setRite(n3);
		n2.setValue();
		Assert.assertEquals(0., n2.getValue(), 0.);

	}

//	@formatter:on

}