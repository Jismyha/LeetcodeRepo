package Array;

/**
 * Leetcode 48.旋转图像
 * Tag: 二维数组，技巧
 * 
 * @author KureNaii
 * @since 2022-07-27 21:42:52
 */
public class Solution48 {
    /**
     * 顺时针旋转 90°
     * 
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        // 先镜像
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // 再逆序
        for (int i = 0; i < matrix.length; i++) {
            reverse(matrix[i]);
        }
    }

    /**
     * （补充）
     * 逆时针旋转 90°
     * 
     * @param matrix
     */
    public void ccwrotate(int[][] matrix) {
        // 先镜像，反对角线镜像
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix.length - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // 再逆序
        for (int i = 0; i < matrix.length; i++) {
            reverse(matrix[i]);
        }
    }

    void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
