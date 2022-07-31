package Array;

/**
 * Leetcode 304.二位区域和检索-矩阵不可变
 * Tag: 数组，前缀和
 * 
 * @author KureNaii
 * @since 2022-07-25 22:58:06
 */
public class Solution304 {
    class NumMatrix {

        // 前缀和
        int[][] matrix;
        int[][] sums;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;

            sums = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 1; i <= matrix.length; i++) {
                for (int j = 1; j <= matrix[0].length; j++) {
                    sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sums[row2 + 1][col2 + 1] + sums[row1][col1] - sums[row1][col2 + 1] - sums[row2 + 1][col1];
        }
    }
}
