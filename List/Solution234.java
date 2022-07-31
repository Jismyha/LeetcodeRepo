package List;

import Public.ListNode;

/**
 * Leetcode 234.回文链表
 * Tag: 链表，递归，双指针
 * 
 * @author KureNaii
 * @since 2022-07-25 23:18:20
 */
public class Solution234 {
    /**
     * 先利用双指针找到链表中点，再反转链表对比是否相同
     * 
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode left = head, right = head;
        while (right != null && right.next != null) {
            right = right.next.next;
            left = left.next;
        }
        ListNode reversed = reverse(left);
        // 注意用 reversed 判断，而不是用 head 判断！！
        while (reversed != null) {
            if (head.val != reversed.val) {
                return false;
            }
            head = head.next;
            reversed = reversed.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reversed = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }
}
