package BinarySearch;

/**
 * Leetcode 1011.在D天内送达包裹的能力
 * Tag:二分查找
 * 
 * @author KureNaii
 * @since 2022-07-20 23:13:43
 */
public class Solution1011 {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for (int i : weights) {
            max = Math.max(max, i);
            sum += i;
        }
        // 注意 left 与 right 的范围！！！
        // left 的值应该是数组最大值，right 的值为数组之和
        int left = max;
        int right = sum;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (f(weights, mid) <= days) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    int f(int[] weights, int x) {
        int days = 0;
        int i = 0;
        while (i < weights.length) {
            int oneDayWeight = 0;
            // 注意一天内能全部装完的情况，防止越界
            while (oneDayWeight <= x && i < weights.length) {
                oneDayWeight += weights[i];
                i++;
            }
            // 注意若和>x，则index需要更新1
            if (oneDayWeight > x) {
                i--;
            }
            days++;
        }
        return days;

    }
}
