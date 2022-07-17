package List;

import Public.ListNode;

/**
 * Leetcode 83.删除排序链表中的重复元素
 * Tag: 链表，双指针
 * 
 * @author KureNaii
 * @since 2022-07-13 22:17:39
 */
public class Solution83 {
    /**
     * 双指针
     * 
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 空指针判断
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        // 只能保证 head~slow不重复，slow 后还有可能重复
        slow.next = null;
        return head;
    }

}
