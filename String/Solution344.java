package String;

/**
 * Leetcode 344.反转字符串
 * Tag: 字符串，双指针
 * 
 * @author KureNaii
 * @since 2022-07-26 21:57:37
 */
public class Solution344 {
    /**
     * 使用左右指针交换两边的值
     * 
     * @param s
     */
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }

    }
}
