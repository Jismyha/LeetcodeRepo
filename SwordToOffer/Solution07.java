package SwordToOffer;

import java.util.HashMap;
import java.util.Map;

import SwordToOffer.Public.TreeNode;

/**
 * 剑指 offer 07.重建二叉树
 * 
 * @author KureNaii
 * @since 2021-12-13 11:29:22
 */
public class Solution07 {

    int[] preorder;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        // 因为无重复数字，可以使用哈希表，缩短查找 inorder 下标的时间
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return recur(0, 0, inorder.length - 1);

    }

    /**
     * 1. Hash 表获得 pre_root 在 inorder 中的下标 in_root;
     * 2. 通过 in_root 可以在 inorder 中划分出左右子树
     * 3. 通过 preorder 求出左右子树的 root
     * 4. 对左右子树分别采用递归
     * 
     * @param pre_root
     * @param in_left
     * @param in_right
     * @return
     */
    public TreeNode recur(int pre_root, int in_left, int in_right) {
        // 终止条件 left > right
        if (in_left > in_right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre_root]);
        int in_root = map.get(preorder[pre_root]);
        // 遍历左子树
        node.left = recur(pre_root + 1, in_left, in_root - 1);
        // 遍历右子树
        node.right = recur(pre_root + in_root - in_left + 1, in_root + 1, in_right);
        return node;
    }

}
