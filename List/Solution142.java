package List;

import Public.ListNode;

/**
 * Leetcode 142.环形链表2
 * Tag: 链表，双指针
 * 
 * @author KureNaii
 * @since 2022-07-22 23:53:45
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 判断有环
            if (fast == slow) {
                // 其中一个指针回到头节点，快慢指针同速前进
                slow = head;
                // 当快慢指针第二次相遇时，在环的头部
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
