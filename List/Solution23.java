package List;

import Public.ListNode;

/**
 * Leetcode 23.合并k个升序链表
 * Tag:链表，双指针
 * 
 * @author KureNaii
 * @since 2022-07-21 22:41:16
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        // 坑
        if (lists.length == 0) {
            return null;
        }
        int right = 1;
        while (right < lists.length) {
            ListNode ll = lists[0];
            ListNode lr = lists[right];
            lists[0] = mergeTwoLists(ll, lr);
            right++;
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 头节点
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
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

        return dummy.next;
    }

}
