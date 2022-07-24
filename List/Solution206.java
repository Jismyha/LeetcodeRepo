package List;

import Public.ListNode;

/**
 * Leetcode 206.反转链表
 * Tag: 链表，递归
 * 
 * @author KureNaii
 * @since 2022-07-23 21:55:20
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        return recur(head);
    }

    ListNode recur(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode reversed = recur(node.next);
        node.next.next = node;
        node.next = null;

        return reversed;
    }
}
