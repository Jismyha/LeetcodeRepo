package Array;

/**
 * Leetcode 344.反转字符串
 * Tag:数组，双指针
 * 
 * @author KureNaii
 * @since 2022-07-14 22:18:12
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
