package SwordToOffer;

/**
 * 剑指 offer 3.数组中重复数字
 * 
 * @author KureNaii
 * @since 2021-09-11 14:45:03
 */
public class Solution03 {
    // 解法 1 哈希表 时间 o(n) 空间 o(n)
    public int findRepeatNumber(int[] nums) {
        // 自动初始化为0
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[nums[i]]++;
            if (result[nums[i]] > 1)
                return nums[i];
        }
        return -1;
    }

    // 解法 2 原地哈希 时间 o(n)
    public int findRepeatNumber2(int[] nums) {
        int result = -1;
        int i = 0;
        while (i < nums.length) {
            // 当下标与指相同，移动指针
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[i] == nums[nums[i]]) {
                result = nums[i];
                return result;
            }
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution03 solution03 = new Solution03();
        int[] nums = { 2, 3, 1, 0, 2, 5, 3 };
        int result = solution03.findRepeatNumber2(nums);
        System.out.println(result);
    }
}
