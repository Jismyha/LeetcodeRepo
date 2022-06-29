import java.util.Arrays;

/**
 * Leetcode 14.最长公共前缀
 * Tag: 排序
 * 
 * @author KureNaii
 * @since 2022-03-22 17:43:25
 */
public class Solution14 {
    /**
     * 利用字典序排序，寻找第一个和最后一个元素的公共前缀
     * 
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String fs = strs[0], ls = strs[strs.length - 1];
        int minSize = Math.min(fs.length(), ls.length());
        int i = 0;
        // while (i <= minSize) {
        // if (fs.substring(0, i).equals(ls.substring(0, i))) {
        // i++;
        // } else {
        // break;
        // }
        // }
        // if (i == 1)
        // return "";
        // else
        // return fs.substring(0, i - 1);

        // 先比较 i 和 minSize 避免越界
        while (i <= minSize && fs.charAt(i) == ls.charAt(i)) {
            i++;
        }
        return fs.substring(0, i);

    }
}
