package Tree;

import java.util.LinkedList;

import Public.TreeNode;

/**
 * Leetcode 297.二叉树的序列化和反序列化
 * Tag:二叉树
 * 
 * @author KureNaii
 * @since 2022-07-12 20:20:13
 */
public class Solution297 {

    // 使用前序遍历来序列化

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        recurSerialize(root, sb);
        return sb.toString();
    }

    void recurSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#");
            sb.append(",");
            return;
        } else {
            sb.append(root.val + "");
            sb.append(",");
        }

        recurSerialize(root.left, sb);
        recurSerialize(root.right, sb);

    }

    // 反序列化需要用到链表辅助
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(",")) {
            nodes.add(s);
        }
        return recurDeserialize(nodes);
    }

    TreeNode recurDeserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }

        // 根节点
        String first = nodes.removeFirst();
        if (first.equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = recurDeserialize(nodes);
        root.right = recurDeserialize(nodes);

        return root;

    }
}
