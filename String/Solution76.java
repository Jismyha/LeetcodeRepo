package String;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 76.最小覆盖子串
 * Tag:字符串，滑动窗口
 * 
 * @author KureNaii
 * @since 2022-07-16 16:01:11
 */
public class Solution76 {
    /**
     * 1. 利用 valid 判断是否满足条件
     * 2. 不满足条件时，扩大窗口
     * 3. 满足条件时，缩小窗口，并更新答案
     * 
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        // count 用于判断是否全覆盖
        int count = 0;
        int rLenth = Integer.MAX_VALUE;
        int rStart = 0;
        while (right < s.length()) {
            char cur = s.charAt(right);
            right++;
            if (need.containsKey(cur)) {
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                // 判断该字符是否已经满足条件
                if (need.get(cur) >= window.get(cur)) {
                    count++;
                }
            }

            while (count == t.length()) {
                // 此处更新结果
                if (rLenth > right - left) {
                    rLenth = right - left;
                    rStart = left;
                }

                char dele = s.charAt(left);
                if (need.containsKey(dele)) {
                    window.put(dele, window.get(dele) - 1);
                    if (need.get(dele) > window.get(dele)) {
                        count--;
                    }
                }
                left++;
            }
        }

        // 需要判断是否能找到
        String res = rLenth == Integer.MAX_VALUE ? "" : s.substring(rStart, rStart + rLenth);
        return res;

    }
}
