package Tree;

import Public.TreeNode;

/**
 * Leetcode 654.最大二叉树
 * Tag: 二叉树
 * 
 * @author KureNaii
 * @since 2022-07-11 22:35:03
 */
public class Solution654 {
    /**
     * 分治
     * 先构造左右子树
     * 
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recur(nums, 0, nums.length - 1);

    }

    // 递归函数
    public TreeNode recur(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return null;
        }

        // 算最大值索引
        int index = leftIndex;
        for (int i = leftIndex; i <= rightIndex; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        // 左子树和右子树
        TreeNode left = recur(nums, leftIndex, index - 1);
        TreeNode right = recur(nums, index + 1, rightIndex);
        TreeNode root = new TreeNode(nums[index], left, right);
        return root;
    }
}
