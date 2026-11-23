package matrixApp;

import java.util.Arrays;

    public class MatrixRotate {
        public static int[][] rotate2x2(int[][] y) {
            return new int[][] {
                    { y[1][0], y[0][0] },
                    { y[1][1], y[0][1] }
            };
        }

        public static void main(String[] args) {
            int[][] input = {
                    {2, 3},
                    {5, 6}
            };
            System.out.println(Arrays.deepToString(rotate2x2(input)));
        }
    }

