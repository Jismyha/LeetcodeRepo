package Array;

/**
 * Leetcode 977.有序数组的平方
 * Tag:数组，双指针
 * 
 * @author KureNaii
 * @since 2022-08-10 21:01:43
 */
public class Solution977 {
    /**
     * 因为最大值肯定在两边选出
     * 使用前后双指针
     * 
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int cur = nums.length - 1;
        while (left <= right) {
            int lnum = nums[left] * nums[left];
            int rnum = nums[right] * nums[right];
            if (lnum <= rnum) {
                res[cur] = rnum;
                right--;
            } else {
                res[cur] = lnum;
                left++;
            }
            cur--;
        }
        return res;
    }
}
