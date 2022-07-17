package String;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 3.无重复字符的最长子串
 * Tag:字符串，滑动窗口
 * 
 * @author KureNaii
 * @since 2022-07-15 21:37:28
 */
public class Solution3 {
    Map<Character, Integer> window = new HashMap<>();

    /**
     * 滑动窗口
     * 
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char add = s.charAt(right);
            // 扩大 window，添加 s[right]
            window.put(add, window.getOrDefault(add, 0) + 1);

            // 每新添一个元素，需判断是否重复出现
            // 若有重复，缩小窗口
            while (window.get(add) > 1) {
                // 缩小 window, 删去 s[left]
                char dele = s.charAt(left);
                left++;
                window.put(dele, window.get(dele) - 1);
            }

            // 窗口大小
            int size = right - left + 1;
            res = Math.max(res, size);

            right++;
        }
        return res;
    }
}
