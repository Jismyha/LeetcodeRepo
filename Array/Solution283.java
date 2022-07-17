package Array;

/**
 * Leetcode 283.移动零
 * Tag: 数组，双指针
 * 
 * @author KureNaii
 * @since 2022-07-13 23:39:34
 */
public class Solution283 {
    /**
     * 思路与 27.移除元素 一致
     * 
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        // 0~slow-1 已经处理完，只用将 slow-nums.length 置为 0 即可
        while (slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }
    }
}
