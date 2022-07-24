package List;

import Public.ListNode;

/**
 * Leetcode 86.分隔链表
 * Tag: 链表，双指针
 * 
 * @author KureNaii
 * @since 2022-07-21 21:51:41
 */
public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode head1 = dummy1;
        ListNode head2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                head1.next = head;
                head1 = head1.next;
            } else {
                head2.next = head;
                head2 = head2.next;
            }
            head = head.next;
        }

        // 注意尾指针置空，否则会出现循环
        head2.next = null;
        head1.next = dummy2.next;
        return dummy1.next;
    }
}
