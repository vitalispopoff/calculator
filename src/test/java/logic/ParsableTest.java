package logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static logic.Parsable.ParsableCache;
import static logic.Parsable.addToParserCache;

public class ParsableTest {

	@Before
	public void initial(){
		Parsable.resetParsableCache();
	}

	@Test
	public void addToParserCache_01(){
		addToParserCache('1');
		Assert.assertEquals("1", ParsableCache.parserCache);
	}

	@Test
	public void addToParserCache_02(){
		addToParserCache('c');
		Assert.assertEquals("", ParsableCache.parserCache);
	}

	@Test
	public void addToParserCache_03(){
		Assert.assertTrue(ParsableCache.isValuePositive);
		addToParserCache((char)8723);
		Assert.assertFalse(ParsableCache.isValuePositive);
	}

	@Test
	public void addToParserCache_04(){
		addToParserCache('1');
		addToParserCache('.');
		addToParserCache('1');
		Assert.assertEquals("1.1", ParsableCache.parserCache);
	}

	@Test
	public void addToParserCache_05(){
		addToParserCache('.');
		addToParserCache('1');
		Assert.assertEquals(".1", ParsableCache.parserCache);
	}

	@Test
	public void addToParserCache_06(){
		addToParserCache('.');
		addToParserCache((char)8723);
		addToParserCache('0');
		addToParserCache('1');
		Assert.assertEquals(".01", ParsableCache.parserCache);
	}

	@Test
	public void dumpParserCache_01(){
		addToParserCache('1');
		Assert.assertEquals(1., Parsable.dumpParserCache(), 0.);
	}

	@Test
	public void dumpParserCache_02(){
		addToParserCache((char)8723);
		addToParserCache('1');
		Assert.assertEquals(-1., Parsable.dumpParserCache(),0.);
	}

	@Test
	public void resetParsableCache_in_dumpParserCache_01(){
		addToParserCache((char)8723);
		addToParserCache('1');
		Parsable.dumpParserCache();
		Assert.assertTrue(ParsableCache.isValuePositive);
	}

	@Test
	public void resetParsableCache_in_dumpParserCache_02(){
		addToParserCache('1');
		Parsable.dumpParserCache();
		Assert.assertEquals("",ParsableCache.parserCache);
	}

}