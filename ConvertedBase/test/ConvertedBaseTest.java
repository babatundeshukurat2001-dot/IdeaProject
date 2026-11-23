import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ConvertedBaseTest {

    @Test
    public void testConvertedBase() {
        ConvertedBase convertedBase = new ConvertedBase(5,10,4);
        assertEquals(11,convertedBase);
    }
}