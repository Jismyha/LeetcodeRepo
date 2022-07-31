package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 54.螺旋数组
 * Tag: 二维数组，技巧
 * 
 * @author KureNaii
 * @since 2022-07-27 22:37:31
 */
public class Solution54 {
    // 四指针按层遍历
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, top = 0, down = m - 1, right = n - 1;
        List<Integer> res = new ArrayList<>();
        while (left <= right && top <= down) {
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            for (int i = top + 1; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            // 必须判断 left right 和 up 与 down,防止只有一列和只有一行的特殊情况
            if (left < right && top < down) {
                for (int j = right - 1; j >= left; j--) {
                    res.add(matrix[down][j]);
                }

                for (int i = down - 1; i >= top + 1; i--) {
                    res.add(matrix[i][left]);
                }
                // 遍历完一层
            }
            top++;
            down--;
            right--;
            left++;

        }
        return res;

    }
}
