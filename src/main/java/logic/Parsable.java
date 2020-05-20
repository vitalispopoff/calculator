package logic;

import static logic.Parsable.ParsableCache.*;

public interface Parsable {

//	@formatter:off

	static void addToParserCache (char c) {
		if (c == 8723)
			toggleSign	();
		else if (isParserAValue	(c) || getParserCache ().equals ("") && c == '.')
			setParserCache (parserCache += c);
	}
	static void resetParsableCache () {
		parserCache = "";
		isValuePositive = true;
	}
	static double dumpParserCache() {
		if (parserCache.length () == 0)
			return Double.NaN;

		double cache
				= Double.parseDouble (getParserCacheString ());

		Parsable.resetParsableCache ();
		return cache;
	}

//	Parsable implementation //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	class ParsableCache implements Parsable {

		static boolean
				isValuePositive = true;
		static String
				parserCache = "";

		static public String getParserCache () { return parserCache; }
		static public void setParserCache (String string) { parserCache = string; }

		static boolean isParserAValue (char c) {
			try {
				Double.parseDouble (parserCache + c);
				return true;
			}
			catch (NumberFormatException e) {
				return false;
			}
		}
		/*static boolean isParserAValue () { return isParserAValue ('\u0000'); }*/	// ? disposable ?

		static String getParserCacheString () { return isValuePositive ? parserCache : "-" + parserCache; }
		static void toggleSign () { isValuePositive = ! isValuePositive; }
	}

//	@formatter:on

}