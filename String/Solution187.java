package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Leetcode 187.重复的 dna 序列
 * Tag: 字符串，滑动窗口
 * 
 * @author KureNaii
 * @since 2022-07-30 22:17:15
 */
public class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        if (s.length() <= 10) {
            return res;
        }

        int left = 0, right = 10;
        // 左闭右开注意循环判断条件
        while (right <= s.length()) {
            String sub = s.substring(left, right);
            // 增加链表重复判断
            if (set.contains(sub) && !res.contains(sub)) {
                res.add(sub);
            } else {
                set.add(sub);
            }
            left++;
            right++;
        }
        return res;
    }
}
