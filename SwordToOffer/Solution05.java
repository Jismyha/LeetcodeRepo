package SwordToOffer;

/**
 * 剑指 offer 5.替换空格
 * 
 * @author KureNaii
 * @since 2021-09-21 03:09:14
 */
public class Solution05 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
