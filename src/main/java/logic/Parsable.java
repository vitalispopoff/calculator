package logic;

public interface Parsable {

	static final ParsableCache cacheWrapper = new ParsableCache();

	void addToParserCache(char c);

	double dumpParserCache();

	class ParsableCache {

		static String mainCache = "";

		static public String getMainCache() {
			return mainCache;
		}

		static public void setMainCache(String string) { mainCache = string; }
	}
}