
//Leetcode: 48
//Complexity: Medium 
import java.util.Arrays;

public class RotateImage {

    String printMatrix(int[][] matrix) {
        StringBuilder sbuf = new StringBuilder();
        int len = matrix[0].length;
        for (int i = 0; i < len; i++) {
            if (i != 0)
                sbuf.append('\n');
            sbuf.append(Arrays.toString(matrix[i]));

        }
        return sbuf.toString();

    }

    // 00 01 02 03
    // 10 11 12 13
    // 20 21 22 23
    // 30 31 32 33

    // 00 -> 03 -> 33-> 30
    // 01 -> 13 -> 32 -> 20
    // 02 -> 23 -> 31 -> 10

    // 11 -> 12 -> 22 -> 21

    class Solution {

        public void rotate(int[][] matrix) {
            int len = matrix[0].length;
            for (int i = 0; i < (len / 2); i++)
                rotate(matrix, i);

        }

        public void rotate(int[][] matrix, int k) {
            int len = matrix[k].length;
            for (int i = k; i < len - 1 - k; i++) {
                int temp = matrix[k][i];
                matrix[k][i] = matrix[len - 1 - i][k];
                matrix[len - i - 1][k] = matrix[len - 1 - k][len - i - 1];
                matrix[len - 1 - k][len - i - 1] = matrix[i][len - 1 - k];
                matrix[i][len - 1 - k] = temp;

            }

        }

    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        RotateImage r = new RotateImage();
        Solution sol = r.new Solution();

        System.out.println(r.printMatrix(matrix));
        System.out.println();
        sol.rotate(matrix);
        System.out.println(r.printMatrix(matrix));

        matrix = new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };

        System.out.println(r.printMatrix(matrix));
        System.out.println();
        sol.rotate(matrix);
        System.out.println(r.printMatrix(matrix));

        matrix = new int[][] { { 1, 2 }, { 3, 4 } };
        System.out.println(r.printMatrix(matrix));
        System.out.println();
        sol.rotate(matrix);
        System.out.println(r.printMatrix(matrix));
    }

}
