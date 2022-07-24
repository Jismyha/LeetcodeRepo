package BinarySearch;

/**
 * Leetcode 34.在排序数组中查找元素的第一个和最后一个位置
 * Tag:二分查找
 * 
 * @author KureNaii
 * @since 2022-07-18 21:13:16
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        int[] res = new int[2];
        res[0] = left;
        res[1] = right;
        return res;
    }

    int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        // left=right+1 时出循环
        // 防止索引溢出
        if (left == nums.length) {
            return -1;
        }

        // left 即为答案
        return nums[left] == target ? left : -1;
    }

    int searchRight(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        // left=right+1 时出循环
        // 防止索引溢出
        if (right < 0) {
            return -1;
        }

        // right 即为答案
        return nums[right] == target ? right : -1;

    }
}
