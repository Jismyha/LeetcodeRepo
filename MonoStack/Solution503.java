package MonoStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Leetcode 503.下一个更大元素ii
 * Tag: 单调栈
 * 
 * @author KureNaii
 * @since 2022-08-01 22:45:49
 */
public class Solution503 {
    /**
     * 循环数组使用取模的方式进行模拟
     * 
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int len = nums.length;
        int[] res = new int[len];
        // 使用取模的方式把数组扩大原来两倍
        for (int i = 2 * len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % len]) {
                stack.pop();
            }
            res[i % len] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % len]);
        }
        return res;
    }
}
