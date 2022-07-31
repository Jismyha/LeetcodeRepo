package Array;

import java.util.Arrays;

import Public.Difference;

/**
 * Leetcode 1094.拼车
 * Tag: 数组，差分数组
 * 
 * @author KureNaii
 * @since 2022-07-26 21:50:33
 */
public class Solution1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] site = new int[1001];
        Arrays.fill(site, capacity);
        Difference diff = new Difference(site);
        for (int[] tripi : trips) {
            int offset = tripi[0] * -1;
            int i = tripi[1];
            // 注意上下车的交叉处，容量计算应该不包含下车处
            int j = tripi[2] - 1;
            diff.increment(i, j, offset);
        }
        site = diff.result(site);
        for (int i : site) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}
