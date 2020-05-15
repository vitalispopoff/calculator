package logic;

public /*abstract */class Parser implements Parsable {

//	@formatter:off

	static private String
			parserCache = "";
	static boolean
			isValueNegative = false;

//	reimplementations \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override
	/*static*/ public void addToParserCache (char c) {
		if (c == 8723)
			isValueNegative = ! isValueNegative;
		else if (isParserAValue (c))
			parserCache += c;
	}

	@Override
	/*static*/ public double dumpParserCache () {
		if (parserCache.length () == 0)
			return Double.NaN;

		double cache
			= Double.parseDouble (getParserCacheString ());

		resetParser ();
		return cache;
	}

//	static  //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	static boolean isParserAValue () { return isParserAValue ('\u0000'); }
	static boolean isParserAValue (char c) {
		try {
			Double.parseDouble (parserCache + c);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}
	static String getParserCacheString () { return isValueNegative? "-"+parserCache : parserCache; }
	static void resetParser () {
		isValueNegative = false;
		parserCache = "";
	}

//	@formatter:on

}