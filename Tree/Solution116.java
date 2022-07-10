package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode 116.填充每个结点的下一个右侧结点指针
 * Tag: 二叉树
 * 
 * @author KureNaii
 * @since 2022-07-10 12:07:17
 */
public class Solution116 {
    Queue<Node> q = new LinkedList<>();

    /**
     * 1.使用 BFS
     * 
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            // 由于要标记层数，所以需要 for 循环记忆
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
                if (i != size - 1) {
                    cur.next = q.peek();
                } else {
                    cur.next = null;
                }
            }
        }
        return root;
    }

    /**
     * 2. dfs
     * 
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return root;
    }

    void dfs(Node root) {
        // 不用遍历到叶子节点
        if (root.left == null) {
            return;
        }
        // 此时处于第 n 层的前序位置，连接 n+1 层的左右节点
        // 连接左边的节点
        root.left.next = root.right;
        // 连接右边的节点,此时第 n 层已经被连接了
        if (root.next != null) {
            root.right.next = root.next.left;
        }

        dfs(root.left);
        dfs(root.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}