package Array;

import java.util.Random;

/**
 * Leetcode 528.按权重随机选择
 * Tag: 数组，技巧，前缀和，二分查找
 * 
 * @author KureNaii
 * @since 2022-07-30 11:30:03
 */
public class Solution528 {
    class Solution {

        private int[] preSum;
        private Random random = new Random();

        /**
         * 使用前缀和数组和二分查找
         * 
         * @param w
         */
        public Solution(int[] w) {
            preSum = new int[w.length + 1];
            preSum[0] = 0;
            // 构造前缀和数组
            for (int i = 1; i <= w.length; i++) {
                preSum[i] = preSum[i - 1] + w[i - 1];
            }
        }

        public int pickIndex() {
            int randnum = random.nextInt(preSum[preSum.length - 1]) + 1;
            int resIndex = binarySearch(randnum);
            return resIndex;
        }

        /**
         * 当目标元素 target 不存在数组 nums 中时，搜索左侧边界的二分搜索的返回值可指：
         * 
         * 1、返回的这个值是 nums 中大于等于 target 的最小元素索引。
         * 
         * 2、返回的这个值是 target 应该插入在 nums 中的索引位置。
         * 
         * 3、返回的这个值是 nums 中小于 target 的元素个数。
         * 
         * @param target
         * @return
         */
        public int binarySearch(int target) {
            int left = 1;
            int right = preSum.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (preSum[mid] == target) {
                    return mid - 1;
                } else if (preSum[mid] < target) {
                    left = mid + 1;
                } else if (preSum[mid] > target) {
                    right = mid - 1;
                }
            }
            // 若未找到
            if (left == preSum.length) {
                return right - 1;
            }

            if (right == 0) {
                return left - 1;
            }

            return left - 1;
        }
    }
}