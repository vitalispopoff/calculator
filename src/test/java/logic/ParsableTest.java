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


}