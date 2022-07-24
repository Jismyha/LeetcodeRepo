package BinarySearch;

/**
 * Leetcode 275.H指数2
 * Tag:二分查找
 * 
 * @author KureNaii
 * @since 2022-07-20 21:09:47
 */
public class Solution275 {

    public int hIndex(int[] citations) {
        // left 与 right 的范围应该是论文数
        // left 应该为 1，而不是 0，因为数组不为空
        int left = 1;
        int right = Math.min(citations.length, 1000);

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[citations.length - mid] >= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
}
