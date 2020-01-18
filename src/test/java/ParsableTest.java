import org.junit.Assert;
import org.junit.Test;

public class ParsableTest {

    @Test
            Assert.assertEquals("1.0", Parsable.valueToStream(1.0d));
}
