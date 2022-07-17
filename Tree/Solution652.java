package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import Public.TreeNode;

/**
 * Leetcode 652.寻找重复的子树
 * Tag:二叉树
 * 
 * @author KureNaii
 * @since 2022-07-12 23:06:30
 */
public class Solution652 {
    HashMap<String, Integer> memo = new HashMap<>();
    List<TreeNode> res = new LinkedList<>();

    /**
     * dfs+序列化
     * 
     * 通过遍历+序列化来判断子树是否有重复
     * 
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }

    String dfs(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = dfs(root.left);
        String right = dfs(root.right);

        // 为了对应后序位置，使用后序遍历来构造子树
        String subTree = left + "," + right + "," + root.val;

        // 此处可用 getOrDefault() 方法

        if (memo.containsKey(subTree)) {
            if (memo.get(subTree) == 0) {
                res.add(root);
                memo.replace(subTree, 1);
            }
        } else {
            memo.put(subTree, 0);
        }

        return subTree;
    }

}
