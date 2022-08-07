package MonoStack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Leetcode 496.下一个更大元素
 * Tag: 单调栈
 * 
 * @author KureNaii
 * @since 2022-08-01 22:28:23
 */
public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            int key = nums2[i];
            int val = stack.isEmpty() ? -1 : stack.peek();
            map.put(key, val);
            stack.push(key);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}