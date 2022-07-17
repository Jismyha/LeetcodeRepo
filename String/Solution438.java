package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode 438.找到字符串中所有字母异位词
 * Tag:字符串，滑动窗口
 * 
 * @author KureNaii
 * @since 2022-07-16 19:19:24
 */
public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char add = s.charAt(right);
            right++;
            if (need.containsKey(add)) {
                window.put(add, window.getOrDefault(add, 0) + 1);
                if (need.get(add).equals(window.get(add))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                if (right - left == p.length()) {
                    res.add(left);
                }

                char dele = s.charAt(left);
                if (need.containsKey(dele)) {
                    if (need.get(dele).equals(window.get(dele))) {
                        valid--;
                    }
                    window.put(dele, window.get(dele) - 1);
                }
                left++;
            }
        }
        return res;
    }
}
