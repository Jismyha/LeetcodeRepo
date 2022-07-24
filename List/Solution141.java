package List;

import Public.ListNode;

/**
 * Leetcode 141.环形链表
 * Tag: 链表，双指针
 * 
 * @author KureNaii
 * @since 2022-07-22 23:53:18
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow, fast;
        slow = head;
        fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
