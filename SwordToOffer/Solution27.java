package SwordToOffer;

import Public.TreeNode;

/**
 * 剑指 offer 27.二叉树的镜像
 * 
 * @author KureNaii
 * @since 2022-07-10 17:10:35
 */
public class Solution27 {
    /**
     * 分治法
     * 
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
