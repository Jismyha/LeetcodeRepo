package Array;

/**
 * Leetcode 303.区域和检索-数组不可变
 * Tag: 数组，前缀和
 * 
 * @author KureNaii
 * @since 2022-07-25 21:23:56
 */
public class Solution303 {
    class NumArray {
        // 前缀和
        int[] sums;
        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            sums = new int[nums.length + 1];
            sums[0] = 0;
            for (int i = 1; i <= nums.length; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return sums[right + 1] - sums[left];
        }
    }
}
