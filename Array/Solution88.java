package Array;

/**
 * Leetcode 88.合并两个有序数组
 * Tag: 数组，双指针
 * 
 * @author KureNaii
 * @since 2022-07-15 20:08:46
 */
public class Solution88 {
    /**
     * 双指针
     * 由于是合并数组，需要从后往前进行遍历
     * 若从前往后，会覆盖后面的值
     * 
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 指针从右往左走，先选出最大的
        // 若从左往右，nums1 数组需要移动数据
        int p1 = m - 1;
        int p2 = n - 1;
        int p3 = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[p3] = nums1[p1];
                p1--;
            } else {
                nums1[p3] = nums2[p2];
                p2--;
            }
            p3--;
        }

        // 可能出现 nums2 数组未插完的情况
        while (p2 >= 0) {
            nums1[p2] = nums2[p2];
            p2--;
        }

    }
}
