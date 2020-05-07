import java.util.ArrayList;

public class Parser implements Parseable {

    static ArrayList<Character> parserCache;

    static {
        parserCache = new ArrayList<>();
        parserCache.add('+');
    }

    @Override
    public void addToValueCache(char c) {
        try {
            Double.parseDouble(parserCache.toString() + c);
            parserCache.add(c);
        } catch (Exception e) {
            System.out.println("Character \"" + c + "\" doesn't fit to the number format.");
        }
    }

    @Override
    public void toggleValueSign() {
        parserCache.set(0, parserCache.get(0) == '+' ? '-' : '+');
    }

    @Override
    public double dumpValueCache() {
        return Double.parseDouble(parserCache.toString());
    }
}