package logic;

import static logic.Parsable.ParsableCache.*;

public interface Parsable {

	static final ParsableCache
			cacheWrapper = ParsableCache.InstanceOf();

	static void addToParserCache(char c) {
		if (c == 8723)
			isValueNegative = ! isValueNegative;
		else if (isParserAValue (c))
//			setParserCache(parserCache += c);
			setParserCache(new StringBuilder().append(parserCache).append(c).toString());

	}

	static double dumpParserCache() { return 0.; }

	static void resetParsableCache() {
		cacheWrapper.parserCache = "";
		cacheWrapper.isValueNegative = false;
	}


//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\

	class ParsableCache implements Parsable {

		static boolean
				isValueNegative = false;
		static String
				parserCache = "";

		private ParsableCache() { }

		static ParsableCache InstanceOf() {
			return Parsable.cacheWrapper
					== null
					? new ParsableCache()
					: Parsable.cacheWrapper;
		}

		static public String getParserCache() {
			return parserCache;
		}

		static public void setParserCache(String string) { parserCache = string; }

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
	}
}