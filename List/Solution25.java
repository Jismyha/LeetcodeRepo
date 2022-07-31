package List;

import Public.ListNode;

/**
 * Leetcode 25.K个一组翻转链表
 * Tag:链表，递归
 * 
 * @author KureNaii
 * @since 2022-07-30 17:10:05
 */
public class Solution25 {
    /**
     * 使用递归
     * 
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // base case
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }

        ListNode pre = reverse(head, tail);
        ListNode reversed = reverseKGroup(tail, k);
        head.next = reversed;
        return pre;
    }

    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null, cur = head;
        ListNode nxt = head;
        while (cur != tail) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
