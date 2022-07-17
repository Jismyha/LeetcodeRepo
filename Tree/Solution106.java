package Tree;

import Public.TreeNode;

/**
 * Leetcode 106.从中序和后序遍历序列构造二叉树
 * Tag:二叉树
 * 
 * 
 * @author KureNaii
 * @since 2022-07-12 08:18:20
 */
public class Solution106 {
    /**
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    TreeNode build(int[] in, int[] post, int inLeft, int inRight, int postIndex) {
        if (inLeft > inRight) {
            return null;
        }

        int rootVal = post[postIndex];
        int rootIndex = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (in[i] == rootVal) {
                rootIndex = i;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        root.left = build(in, post, inLeft, rootIndex - 1, postIndex - (inRight - rootIndex) - 1);
        root.right = build(in, post, rootIndex + 1, inRight, postIndex - 1);
        return root;

    }
}
