package Tree;

import Public.TreeNode;

/**
 * Leetcode 105.从前序和中序遍历序列构造二叉树
 * Tag:二叉树
 * 
 * @author KureNaii
 * @since 2022-07-11 22:36:47
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length - 1, 0);
    }

    /**
     * 分治
     * 
     * 1. 使用 inorder 数组构建树，因为 inorder 才能区分左右子树
     * 2. 类似 构建最大二叉树，只不过 root 的值不是通过大小判断，而是通过 preorder 数组确定
     * 3. 由于需要用 preorder 确定 root 的值，所以函数需要多加上一个 preIndex 参数，用于给子树确定 root 的值
     * 
     * @param pre
     * @param in
     * @param inLeft
     * @param inRight
     * @param preIndex
     * @return
     */
    public TreeNode build(int[] pre, int[] in, int inLeft, int inRight, int preIndex) {
        if (inLeft > inRight) {
            return null;
        }
        // 类似于找最大值，而此时的最大值关系应该是 inorder 中的根节点位置
        int rootVal = pre[preIndex];
        int rootIndex = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (rootVal == in[i]) {
                rootIndex = i;
            }
        }

        TreeNode root = new TreeNode(rootVal); // 构造左子树
        root.left = build(pre, in, inLeft, rootIndex - 1, preIndex + 1);
        root.right = build(pre, in, rootIndex + 1, inRight, preIndex + rootIndex - inLeft + 1);

        return root;
    }
}
