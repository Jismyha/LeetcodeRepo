package String;

/**
 * Leetcode 151.颠倒字符串中的单词
 * Tag:字符串，双指针
 * 
 * @author KureNaii
 * @since 2022-07-26 23:08:06
 */
public class Solution151 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c != ' ') {
                sb.append(c);
            } else if (sb.length() != 0 && sb.charAt(sb.length() - 1) != ' ') {
                sb.append(' ');
            }
        }
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }

        // 先reverese整个字符串
        char[] string = sb.toString().toCharArray();
        reverse(string, 0, string.length - 1);

        for (int i = 0; i < string.length;) {
            for (int j = i; j < string.length; j++) {
                if (j == string.length - 1 || string[j + 1] == ' ') {
                    reverse(string, i, j);
                    i = j + 2;
                    break;
                }
            }
        }
        return new String(string);
    }

    void reverse(char[] string, int i, int j) {
        while (i < j) {
            char tmp = string[j];
            string[j] = string[i];
            string[i] = tmp;
            i++;
            j--;
        }
    }
}
