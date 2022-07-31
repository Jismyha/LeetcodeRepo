package Array;

public class Solution59 {
    /**
     * 解法同 54 题
     * 
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int left = 0, right = n - 1, top = 0, down = n - 1;
        int[][] res = new int[n][n];
        int num = 0;
        while (left <= right && top <= down) {
            for (int j = left; j <= right; j++) {
                num++;
                res[top][j] = num;
            }
            for (int i = top + 1; i <= down; i++) {
                num++;
                res[i][right] = num;
            }

            if (left < right && top < down) {
                for (int j = right - 1; j >= left; j--) {
                    num++;
                    res[down][j] = num;
                }

                for (int i = down - 1; i > top; i--) {
                    num++;
                    res[i][left] = num;
                }
            }
            left++;
            right--;
            top++;
            down--;
        }
        return res;
    }
}
