package Daily;

import java.util.Arrays;

/**
 * Leetcode 849.到最近的人的最大距离
 * Tag:
 * 
 * @author KureNaii
 * @since 2023-08-22 23:14:58
 */
class Solution849 {
    public static int maxDistToClosest(int[] seats) {
        int len = seats.length;
        int[] tmpArry = new int[len];
        // 遍历seats数组
        for (int i = 0; i < len; i++) {
            // tmp数组记录最大距离，若有人，则赋值为0
            if (seats[i] == 1) {
                tmpArry[i] = 0;
            } else {
                int left = 0;
                int right = 0;
                int tmpResult = 0;
                for (int j = i; j >= 0; j--) {
                    if (seats[j] == 1) {
                        left = i - j;
                        break;
                    }
                }
                for (int k = i; k <= len - 1; k++) {
                    if (seats[k] == 1) {
                        right = k - i;
                        break;
                    }
                }
                // 需要考虑只有一个人的情况
                if (left == 0 || right == 0) {
                    tmpResult = Math.max(left, right);
                } else {
                    tmpResult = Math.min(left, right);
                }
                tmpArry[i] = tmpResult;
            }
        }
        Arrays.sort(tmpArry);
        return tmpArry[len - 1];
    }

    public static void main(String[] args) {
        int[] test = { 1, 0, 0, 0, 1, 0, 1 };
        maxDistToClosest(test);
    }
}