package Tree;

import Public.TreeNode;

/**
 * Leetcode 226.翻转二叉树
 * Tag:
 * 
 * @author KureNaii
 * @since 2022-07-10 11:57:49
 */
public class Solution226 {

    /**
     * 分治
     * 翻转结果 = 左子树的翻转结果 + 右子树的翻转结果
     * 再进行翻转
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 左子树翻转结果+右子树翻转结果
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
