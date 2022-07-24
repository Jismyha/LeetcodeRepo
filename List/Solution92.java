package List;

import Public.ListNode;

/**
 * Leetcode 92.反转链表2
 * Tag: 链表，递归
 * 
 * @author KureNaii
 * @since 2022-07-23 21:56:33
 */
public class Solution92 {
    ListNode successor = null;
    ListNode predecessor = null;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        int lenth = right - left + 1;
        left = left + 1;

        while (left > 1) {
            if (left == 2) {
                predecessor = cur;
            }
            cur = cur.next;
            left--;
        }

        predecessor.next = recur(cur, lenth);
        return dummy.next;
    }

    public ListNode recur(ListNode head, int num) {
        if (num == 1) {
            successor = head.next;
            return head;
        }

        ListNode reversed = recur(head.next, num - 1);
        head.next.next = head;
        head.next = successor;

        return reversed;
    }
}
