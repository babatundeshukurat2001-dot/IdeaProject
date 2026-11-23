package matrixApp;

import org.junit.jupiter.api.Test;

import static matrixApp.MatrixRotate.rotate2x2;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixRotateTest {

    @Test
    public void testRotate2x2_Basic() {
        int[][] input = {
                {2, 3},
                {5, 6}
        };
        int[][] expected = {
                {5, 2},
                {6, 3}
        };
        assertArrayEquals(expected, rotate2x2(input));
    }

    @Test
    public void testRotate2x2_AnotherMatrix() {
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        int[][] expected = {
                {3, 1},
                {4, 2}
        };
        assertArrayEquals(expected, rotate2x2(input));
    }

    @Test
    public void testRotate2x2_Zeros() {
        int[][] input = {
                {0, 0},
                {1, 1}
        };
        int[][] expected = {
                {1, 0},
                {1, 0}
        };
        assertArrayEquals(expected, rotate2x2(input));
    }
}