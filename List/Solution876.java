package List;

import Public.ListNode;

/**
 * Leetcode 876.单链表的中间节点
 * Tag: 链表，双指针
 * 
 * @author KureNaii
 * @since 2022-07-22 23:52:46
 */
public class Solution876 {
    public ListNode middleNode(ListNode head) {
        ListNode left, right;
        left = head;
        right = head;
        while (right != null) {
            right = right.next;
            if (right != null) {
                left = left.next;
                right = right.next;
            }
        }
        return left;
    }
}
