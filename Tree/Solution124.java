package Tree;

import Public.TreeNode;

/**
 * Leetcode 124.二叉树的最大路径和
 * Tag: 二叉树
 * 
 * @author KureNaii
 * @since 2022-07-02 19:50:12
 */
public class Solution124 {
    int maxSum = 0;

    public int maxPathSum(TreeNode root) {
        maxSum = root.val;
        oneSideMax(root);
        return maxSum;
    }

    /**
     * 一个节点的最大路径 = 左子树的最大单边路径 + 右子树的单边最大路径
     * 
     * @param root
     * @return
     */
    int oneSideMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 若节点 < 0，则不取该节点
        int leftMax = Math.max(0, oneSideMax(root.left));
        int rightMax = Math.max(0, oneSideMax(root.right));
        int res = leftMax + rightMax + root.val;
        maxSum = Math.max(maxSum, res);
        return Math.max(leftMax, rightMax) + root.val;
    }

}
