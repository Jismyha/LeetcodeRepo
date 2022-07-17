package String;

/**
 * Leetcode 5.最长回文字串
 * Tag: 字符串，双指针
 * 
 * @author KureNaii
 * @since 2022-07-14 23:30:54
 */
public class Solution5 {
    /**
     * 寻找回文串，使用双指针相对而行
     * 
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String longest = "";
        // 遍历 s 中的所有节点
        for (int i = 0; i < s.length(); i++) {
            // 每个节点分奇数和偶数两种情况
            String odd = findPalindrome(s, i, i);
            String even = findPalindrome(s, i, i + 1);
            String longer = odd.length() > even.length() ? odd : even;
            if (longer.length() > longest.length()) {
                longest = longer;
            }
        }
        return longest;
    }

    /**
     * 以中心向两边寻找回文串，回文串的情况按照长度分为奇数和偶数
     * 长度为奇数中心只有一个字符 {@code li==ri}
     * 长度为偶数中心有两个字符 {@code ri=li+1}
     * 
     * @param s
     * @param li
     * @param ri
     * @return
     */
    String findPalindrome(String s, int li, int ri) {
        while (li >= 0 && ri <= s.length() - 1 && s.charAt(li) == s.charAt(ri)) {
            li--;
            ri++;
        }
        // substring 函数左闭右开
        return s.substring(li + 1, ri);
    }

}
