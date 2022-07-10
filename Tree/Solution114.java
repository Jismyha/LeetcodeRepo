package Tree;

import Public.TreeNode;

/**
 * Leetcode 114.二叉树展开为链表
 * Tag: 二叉树
 * 
 * @author KureNaii
 * @since 2022-07-10 10:34:54
 */
public class Solution114 {
    /**
     * 分治
     * 对于一个节点而言，展开链表分为三个步骤
     * 1.左右子树分别展开链表
     * 2.左子树移动到节点的右侧
     * 3.右子树移动到左子树的右侧
     * 
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        // 左右子树已展开
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 先移动左子树
        root.left = null;
        root.right = left;

        // 再将右子树移动到左子树下方
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

}
