package Array;

/**
 * Leetcode 27.移除元素
 * Tag: 数组，双指针
 * 
 * @author KureNaii
 * @since 2022-07-13 23:37:03
 */
public class Solution27 {
    /**
     * 双指针
     * fast和slow同时往前遍历，fast要给slow传值，当遇到要删除出的，val时，fast往前，slow不动
     * 
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        // 与删除数组中重复项不同
        return slow;
    }

}
