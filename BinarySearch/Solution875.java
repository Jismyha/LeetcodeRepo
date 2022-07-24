package BinarySearch;

/**
 * Leetcode 875.爱吃香蕉的珂珂
 * Tag: 二分搜索
 * 
 * @author KureNaii
 * @since 2022-07-19 23:59:01
 */
public class Solution875 {
    /**
     * 已知 k 与 h 为单调关系，在给定的 h 中求最小的 x
     * 可使用搜索左侧边界的二分法
     * 重点在于 f(x) 和 x 范围的求解
     * 
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        // 首先确定 x 的范围
        int left = 1;
        // 最大速度应该为给定数组中的最大数
        int MAX_PILES = 1;
        for (int i = 0; i < piles.length; i++) {
            if (MAX_PILES <= piles[i]) {
                MAX_PILES = piles[i];
            }
        }
        int right = MAX_PILES;
        while (left <= right) {
            int mid = left + right >> 1;
            if (f(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 因为值一定存在，所以不用考虑越界情况
        return left;
    }

    /**
     * h = f(x)
     * 
     * @param piles
     * @param k
     * @return
     */
    public long f(int[] piles, int k) {
        long hour = 0;
        for (int i = 0; i < piles.length; i++) {
            hour += piles[i] / k;
            // 剩余不足 k 根，也按一小时算
            if (piles[i] % k > 0) {
                hour++;
            }
        }
        return hour;
    }

}
