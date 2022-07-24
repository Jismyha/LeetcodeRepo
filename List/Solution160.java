package List;

import Public.ListNode;

/**
 * Leetcode 160.相交链表
 * Tag: 链表，双指针
 * 
 * @author KureNaii
 * @since 2022-07-23 13:19:00
 */
public class Solution160 {
    /**
     * 由于a和b的非公共部分不一定等长
     * 重点在于p1，p2如何同时到达c1
     * 
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}
