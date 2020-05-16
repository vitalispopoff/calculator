package logic;

import static logic.Parsable.ParsableCache.*;

public interface Parsable {

/*	static final ParsableCache
			cacheWrapper = ParsableCache.InstanceOf();*/

	static void addToParserCache(char c) {
		if (c == 8723)
			toggleSign();
		else if (isParserAValue(c) || getParserCache() == "" && c == '.')
			setParserCache(parserCache += c);
	}

	static double dumpParserCache() {
		if (parserCache.length() == 0)
			return Double.NaN;

		double cache
				= Double.parseDouble(getParserCacheString());

		Parsable.resetParsableCache();
		return cache;
	}

	static void resetParsableCache() {
		/*cacheWrapper.*/parserCache = "";
		/*cacheWrapper.*/isValuePositive = true;


	}


//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	class ParsableCache implements Parsable {

		static boolean
				isValuePositive = true;
		static String
				parserCache = "";

		private ParsableCache() { }

/*		static ParsableCache InstanceOf() {
			return Parsable.cacheWrapper
					== null
					? new ParsableCache()
					: Parsable.cacheWrapper;
		}*/

		static void toggleSign() {
			isValuePositive = !isValuePositive;
		}

		static public String getParserCache() {
			return parserCache;
		}

		static public void setParserCache(String string) { parserCache = string; }

		static boolean isParserAValue() { return isParserAValue('\u0000'); }

		static boolean isParserAValue(char c) {
			try {
				Double.parseDouble(parserCache + c);
				return true;
			}
			catch (NumberFormatException e) {
				return false;
			}

		}

		static String getParserCacheString() { return isValuePositive ? parserCache : "-" + parserCache; }
	}
}