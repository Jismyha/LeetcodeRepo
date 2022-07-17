package Array;

/**
 * Leetcode 167.两数之和II
 * Tag: 数组，双指针
 * 
 * @author KureNaii
 * @since 2022-07-14 22:17:05
 */
public class Solution167 {
    /**
     * 左右指针，类似二分查找
     * 
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            }
        }
        return res;
    }
}
