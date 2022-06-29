package SwordToOffer;

/**
 * 剑指 offer 4.二维数组查找
 * 
 * @author KureNaii
 * @since 2021-09-21 02:41:52
 */
class Solution {
    // 由于矩阵的特殊结构，从右上角或左下角开始搜索，能排除行列
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 判断特殊情况
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int raw = 0, col = matrix[0].length - 1;
        while (col >= 0 && raw < matrix.length) {
            int flag = matrix[raw][col];
            if (flag == target) {
                return true;
            } else if (flag < target) {
                raw++;
            } else {
                col--;
            }
        }
        return false;
    }
}
