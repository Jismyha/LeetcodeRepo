package List;

import Public.ListNode;

/**
 * Leetcode 21.合并两个有序链表
 * Tag: 链表，双指针
 * 
 * @author KureNaii
 * @since 2022-07-21 21:20:51
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 虚拟头节点
        ListNode head = new ListNode(0);
        ListNode p = head;
        ListNode p1, p2;
        p1 = list1;
        p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        } else {
            p.next = p2;
        }

        return head.next;
    }

}
