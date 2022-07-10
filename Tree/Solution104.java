package Tree;

import Public.TreeNode;

/**
 * Leetcode 104.二叉树的最大深度
 * Tag: 二叉树
 * 
 * @author KureNaii
 * @since 2022-07-02 22:14:44
 */
public class Solution104 {
    /**
     * 分治递归求解
     * 
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftdepth = maxDepth(root.left);
        int rightdepth = maxDepth(root.right);
        return Math.max(leftdepth, rightdepth) + 1;

    }

}
