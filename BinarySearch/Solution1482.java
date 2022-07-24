package BinarySearch;

/**
 * Leetcode 1482.制作m束花所需的最少天数
 * Tag:二分查找
 * 
 * @author KureNaii
 * @since 2022-07-20 23:56:12
 */
public class Solution1482 {
    /**
     * x 为时间，m 为花的数量，可知 m 与 x 成正比
     * 在给定的 m 下 求出 x 左边界值
     * 可使用二分法
     * 
     * @param bloomDay
     * @param m
     * @param k
     * @return
     */
    public int minDays(int[] bloomDay, int m, int k) {
        // 注意判断 -1 的情况
        if (m * k > bloomDay.length) {
            return -1;
        }

        int max = 0;
        int min = 0;
        for (int i : bloomDay) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        int left = min;
        int right = max;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(bloomDay, m, k, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    boolean check(int[] bloomDay, int m, int k, int x) {
        // days>=m 返回 true
        int left = 0;
        int right = k - 1;
        int flowers = 0;
        // 此处可优化
        while (right < bloomDay.length) {
            boolean flag = true;
            for (int i = left; i <= right; i++) {
                if (bloomDay[i] > x) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                flowers++;
                left = right;
                right = right + k - 1;
            }
            left++;
            right++;
        }

        if (flowers >= m) {
            return true;
        } else {
            return false;
        }
    }
}
