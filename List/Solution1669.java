package List;

import Public.ListNode;

/**
 * Leetcode 1669.合并两个链表
 * Tag:链表，模拟
 * 
 * @author KureNaii
 * @since 2022-07-15 20:52:31
 */
public class Solution1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur1 = list1;
        ListNode pre = null, post = null;
        while (b >= 0) {
            if (a == 1) {
                pre = cur1;
            }
            cur1 = cur1.next;
            a--;
            b--;
        }
        post = cur1;
        pre.next = list2;

        while (list2.next != null) {
            list2 = list2.next;
        }

        list2.next = post;
        return list1;
    }

}
