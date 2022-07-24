package List;

import Public.ListNode;

/**
 * Leetcode 19.删除链表的倒数第N个结点
 * Tag:链表，双指针
 * 
 * @author KureNaii
 * @since 2022-07-21 23:38:37
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head;
        ListNode right = head;
        boolean flag = false;
        // 删头节点为边界情况
        for (int i = 0; i <= n; i++) {
            if (right == null && i == n) {
                flag = true;
                break;
            }
            right = right.next;
        }

        if (flag) {
            return head.next;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return head;
    }
}
