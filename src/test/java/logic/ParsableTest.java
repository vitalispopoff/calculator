package logic;

import org.junit.*;

import static logic.Parsable.addToParserCache;

public class ParsableTest {

//	@formatter:off

	@Before public void initial(){
		Parsable.resetParsableCache();
	}

	@Test public void addToParserCache_01(){
		addToParserCache('1');
		Assert.assertEquals("1", Parsable.parsableCache.parserCache);
	}
	@Test public void addToParserCache_02(){
		addToParserCache('c');
		Assert.assertEquals("", Parsable.parsableCache.parserCache);
	}
	@Test public void addToParserCache_03(){
		Assert.assertTrue(Parsable.parsableCache.isValuePositive);
		addToParserCache((char)8723);
		Assert.assertFalse(Parsable.parsableCache.isValuePositive);
	}
	@Test public void addToParserCache_04(){
		addToParserCache('1');
		addToParserCache('.');
		addToParserCache('1');
		Assert.assertEquals("1.1", Parsable.parsableCache.parserCache);
	}
	@Test public void addToParserCache_05(){
		addToParserCache('.');
		addToParserCache('1');
		Assert.assertEquals(".1", Parsable.parsableCache.parserCache);
	}
	@Test public void addToParserCache_06(){
		addToParserCache('.');
		addToParserCache((char)8723);
		addToParserCache('0');
		addToParserCache('1');
		Assert.assertEquals(".01", Parsable.parsableCache.parserCache);
	}

	@Test public void dumpParserCache_01(){
		addToParserCache('1');
		Assert.assertEquals(1., Parsable.dumpParserCache(), 0.);
	}
	@Test public void dumpParserCache_02(){
		addToParserCache((char)8723);
		addToParserCache('1');
		Assert.assertEquals(-1., Parsable.dumpParserCache(),0.);
	}

	@Test public void resetParsableCache_in_dumpParserCache_01(){
		addToParserCache((char)8723);
		addToParserCache('1');
		Parsable.dumpParserCache();
		Assert.assertTrue(Parsable.parsableCache.isValuePositive);
	}
	@Test public void resetParsableCache_in_dumpParserCache_02(){
		addToParserCache('1');
		Parsable.dumpParserCache();
		Assert.assertEquals("",Parsable.parsableCache.parserCache);
	}

//	@formatter:on

}