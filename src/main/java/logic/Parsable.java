package logic;

import static logic.Parsable.ParsableCache.*;

public interface Parsable {

	static final ParsableCache parsableCache = new ParsableCache();

//	@formatter:off

	static void addToParserCache (char c) {
/*		if (c == 8723)
			toggleSign();
		else*/
	if (ParsableCache.isParserAValue	(c) || getParserCache ().equals ("") && c == '.')
			setParserCache (parsableCache.parserCache += c);
	}
	static void resetParsableCache () {
		parsableCache.parserCache = "";
		parsableCache.isValuePositive = true;
	}
	static double dumpParserCache() {
		if (parsableCache.parserCache.length () == 0)
			return Double.NaN;

		double cache
				= Double.parseDouble (getParserCacheString ());

		Parsable.resetParsableCache ();
		return cache;
	}
	static void toggleSign () { parsableCache.isValuePositive = ! parsableCache.isValuePositive; }

	static boolean isParserAValue() {
		try {
			Double.parseDouble (Parsable.parsableCache.parserCache);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}

//	Parsable implementation //\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	class ParsableCache implements Parsable {

		public boolean
				isValuePositive = true;
		public String
				parserCache = "";

		static public String getParserCache () { return Parsable.parsableCache.parserCache; }
		static public void setParserCache (String string) { Parsable.parsableCache.parserCache = string; }

		static boolean isParserAValue (char c) {
			try {
				Double.parseDouble (Parsable.parsableCache.parserCache + c);
				return true;
			}
			catch (NumberFormatException e) {
				return false;
			}
		}

		static String getParserCacheString () {
			return Parsable.parsableCache.isValuePositive
					? Parsable.parsableCache.parserCache
					: "-" + Parsable.parsableCache.parserCache;
		}
	}



//	@formatter:on

}