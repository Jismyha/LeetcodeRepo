package String;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 567.字符串的排列
 * Tag:字符串，滑动窗口
 * 
 * @author KureNaii
 * @since 2022-07-16 19:44:31
 */
public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char cur = s2.charAt(right);
            right++;

            if (need.containsKey(cur)) {
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                // 注：此处判断需要用 equals()
                if (need.get(cur).equals(window.get(cur))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                // 判断结果
                if (right - left == s1.length()) {
                    return true;
                }

                char dele = s2.charAt(left);
                left++;

                if (need.containsKey(dele)) {
                    // 注：此处判断需要用 equals()
                    if (need.get(dele).equals(window.get(dele))) {
                        valid--;
                    }
                    window.put(dele, window.get(dele) - 1);
                }
            }
        }
        return false;
    }

}
