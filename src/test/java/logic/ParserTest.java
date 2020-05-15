package logic;

import org.junit.*;

public class ParserTest {

//	@formatter:off

	@Before public void initial () { Parser.resetParser(); }

	@Test public void addToParserCache_01 () {
		Parser.addToParserCache ('1');
		Assert.assertEquals ("1", Parser.getParserCacheString ());
	}
	@Test public void addToParserCache_02 () {
		Parser.addToParserCache ('c');
		Assert.assertEquals ("", Parser.getParserCacheString ());
	}
	@Test public void addToParserCache_03 () {
		Parser.addToParserCache ( (char) 8723);
		Assert.assertEquals ("-", Parser.getParserCacheString ());
	}
	@Test public void addToParserCache_04 () {
		Parser.addToParserCache ('1');
		Parser.addToParserCache ('.');
		Parser.addToParserCache ('1');
		Assert.assertEquals ("1.1", Parser.getParserCacheString ());
	}

//	@formatter:on

	@Test
	public void dumpParserCache_01(){
		Parser.addToParserCache('1');
		Assert.assertEquals(1., Parser.dumpParserCache(),0.);

	}

	@Test
	public void dumpParserCache_02(){
		Parser.addToParserCache('1');
		Parser.dumpParserCache();
		Assert.assertEquals("", Parser.getParserCacheString());
	}

	@Test
	public void dumpParserCache_03(){
		Parser.addToParserCache((char)8723);
		Parser.addToParserCache('1');
		Assert.assertEquals(-1.,Parser.dumpParserCache(),0.);
	}

	@Test
	public void dumpParserCache_04(){
		Parser.addToParserCache((char)8723);
		Parser.addToParserCache('1');
		Parser.dumpParserCache();
		Assert.assertFalse(Parser.isValueNegative);
	}

	@Test
	public void dumpParserCache_05(){
		Parser.addToParserCache((char)8723);
		Parser.addToParserCache('1');
		Parser.dumpParserCache();
		Assert.assertEquals("", Parser.getParserCacheString());
	}

}