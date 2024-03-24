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
    /**
     * 穷举
     * 
     * @param seats
     * @return
     */
    public int maxDistToClosest(int[] seats) {
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

    /**
     * 双指针
     * 
     * @param seats
     * @return
     */
    public int maxDistToClosest2(int[] seats) {
        int left = 0;
        int right = 0;
        int result = 0;
        while (right <= seats.length - 1) {
            // 右指针为1或右指针结束都需要计算值
            if (seats[right] == 1 || right == seats.length - 1) {
                // 左边界与右边界
                if ((left == 0 && seats[left] != 1) || (right == seats.length - 1 && seats[right] != 1)) {
                    result = Math.max(right - left, result);
                } else {
                    result = Math.max((right - left) / 2, result);
                }
                left = right;
            }
            right++;
        }
        return result;
    }
}
