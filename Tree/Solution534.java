package Tree;

import Public.TreeNode;

/**
 * Leetcode 534.二叉树的直径
 * Tag: 二叉树
 * 
 * @author KureNaii
 * @since 2022-07-02 22:00:53
 */
public class Solution534 {
    // 全局变量
    int maxDiameter = 0;

    /**
     * 
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    /**
     * 一个节点的最大直径 = 该节点左子树的最大深度 + 该节点右子树的最大深度
     * 
     * @param root
     * @return
     */
    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        // 在求完左右子树的最大深度后求出该节点的直径，并更新全局变量
        maxDiameter = Math.max(maxDiameter, leftMax + rightMax);

        return Math.max(leftMax, rightMax) + 1;
    }

}
