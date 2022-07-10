package SwordToOffer;

import Public.ListNode;

/**
 * 剑指 offer 22.倒数第K个节点
 * 
 * @author KureNaii
 * @since 2022-03-24 23:30:44
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int n) {
        ListNode left = head, right = head;
        // 让左右指针相差n个位置
        while (n != 0) {
            right = right.next;
            n--;
        }
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        return left;
    }
}
