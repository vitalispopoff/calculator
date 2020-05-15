package logic;

public interface Parsable {

	void addToParserCache(char c);

	double dumpParserCache();
}