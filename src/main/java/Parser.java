public abstract class Parser implements Parsable {

//	@formatter:off

	static boolean
			isValueNegative = false;
	static private String
			parserCache = "";

//	Overrides \\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	@Override
	public void addToParserCache (char c) {
		if (c == 8723) isValueNegative = ! isValueNegative;
		else if (isParserAValue (c)) parserCache += c;
	}

	@Override
	public double dumpParserCache () {
		if (parserCache.length () == 0) return Double.NaN;
		double cache
				= isValueNegative
				? -1. * Double.parseDouble (parserCache)
				: Double.parseDouble (parserCache);
		resetParser ();
		return cache;
	}

//	static  //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	static public boolean isParserAValue () {
		return isParserAValue ('\u0000');
	}

	static boolean isParserAValue (char c) {
		try {
			Double.parseDouble (parserCache + c);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}

	static public void resetParser () {
		isValueNegative = false;
		parserCache = "";
	}

	static String getParserCache () {
		return parserCache;
	}

//	@formatter:on

}