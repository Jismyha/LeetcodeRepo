package String;

/**
 * Leetcode 125.验证回文串
 * Tag: 字符串，双指针
 * 
 * @author KureNaii
 * @since 2022-07-16 10:21:38
 */
public class Solution125 {
    public boolean isPalindrome(String s) {
        // 处理字符串
        // 注：toLowerCase()不改变字符串本身
        String lower = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lower.length(); i++) {
            char cur = lower.charAt(i);
            if (cur >= '0' && cur <= '9') {
                sb.append(cur);
            } else if (cur >= 'a' && cur <= 'z') {
                sb.append(cur);
            }
        }

        // 利用双指针判断回文串
        int left = 0, right = sb.length() - 1;
        System.out.println(sb.toString());

        while (left <= right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
