import java.util.Arrays;

/**
 * Leetcode 1288.删除被覆盖区间
 * Tag:排序，区间问题
 * 
 * @author KureNaii
 * @since 2022-03-22 17:57:51
 */
public class Solution1288 {
    /**
     * 先将二维数组按照行排序,按照 x.begin 的升序，x.end 的降序进行排列
     * 只需要对
     * 
     * @param intervals
     * @return
     */
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });
        int right = intervals[0][1];
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] tmp = intervals[i];
            // 覆盖
            if (right >= tmp[1]) {
                res++;
            } else {
                right = tmp[1];
            }
        }
        return intervals.length - res;
    }

    public static void main(String[] args) {
        Solution1288 solution1288 = new Solution1288();
        int[][] intervals = { { 1, 4 }, { 3, 6 }, { 2, 8 } };
        System.out.println(solution1288.removeCoveredIntervals(intervals));
    }

}