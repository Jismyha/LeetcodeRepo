package Tree;

import Public.TreeNode;

/**
 * Leetcode 889.根据前序和后序遍历构造二叉树
 * Tag: 二叉树
 * 
 * @author KureNaii
 * @since 2022-07-12 19:22:34
 */
public class Solution889 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // 以左子树优先的规则构造树
        return build(preorder, postorder, 0, 0, postorder.length - 1);
    }

    /**
     * 分治
     * 
     * 以后序为基础，左子树优先进行构造
     * 通过对左子树的根在后序中的位置来确定左右子树的范围
     * 
     * @param pre
     * @param post
     * @param preIndex
     * @param postLeft
     * @param postRight
     * @return
     */
    public TreeNode build(int[] pre, int[] post, int preIndex, int postLeft, int postRight) {
        // basic case
        if (postLeft > postRight) {
            return null;
        }

        // 将叶子节点单独判断，避免AOB
        if (postLeft == postRight) {
            return new TreeNode(post[postLeft]);
        }

        int rootVal = pre[preIndex];
        // 找到左子树的根节点
        int leftRootIndex = 0;
        for (int i = postLeft; i <= postRight; i++) {
            if (post[i] == pre[preIndex + 1]) {
                leftRootIndex = i;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        root.left = build(pre, post, preIndex + 1, postLeft, leftRootIndex);
        root.right = build(pre, post, preIndex + leftRootIndex - postLeft + 2, leftRootIndex + 1, postRight - 1);
        return root;

    }

}
