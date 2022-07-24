package BinarySearch;

/**
 * Leetcode 704.二分查找
 * Tag: 二分查找
 * 
 * @author KureNaii
 * @since 2022-07-18 20:59:59
 */
public class Solution704 {
    public int search(int[] nums, int target) {
        // 左闭右开区间
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return -1;
    }
}
