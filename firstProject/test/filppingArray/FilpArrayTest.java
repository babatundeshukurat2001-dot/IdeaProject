package filppingArray;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FilpArrayTest {

    @Test
    void testSwapWhenSumIsOdd() {
        int[] input = {1, 2, 3, 4};
        int[] expected = {2, 1, 4, 3};
        assertArrayEquals(expected, FilpArray.flipNumbers(input));
    }

    }