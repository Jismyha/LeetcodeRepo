package Array;

import Public.Difference;

/**
 * Leetcode 1109.航班预订统计
 * Tag: 数组，差分数组
 * 
 * @author KureNaii
 * @since 2022-07-26 21:51:44
 */
public class Solution1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        Difference diff = new Difference(res);
        for (int[] booki : bookings) {
            int left = booki[0] - 1;
            int right = booki[1] - 1;
            int offset = booki[2];
            diff.increment(left, right, offset);
        }
        return diff.result(res);
    }
}
