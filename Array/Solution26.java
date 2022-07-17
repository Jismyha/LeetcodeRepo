package Array;

/**
 * Leetcode 26.删除有序数组中的重复项
 * Tag: 数组，双指针
 * 
 * @author KureNaii
 * @since 2022-07-13 08:15:57
 */
public class Solution26 {
    /**
     * 快慢指针
     * 快指针的与慢指针不同时，慢指针后移且赋值
     * 当快指针遍历完结束
     * 
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (fast <= nums.length - 1) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

}
